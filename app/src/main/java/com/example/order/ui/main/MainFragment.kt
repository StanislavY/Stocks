package com.example.order.ui.main

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.order.AppState
import com.example.order.Data.Keys
import com.example.order.Data.Keys.KEY_FOR_INFLATE_MAIN_LIST
import com.example.order.Data.Keys.count
import com.example.order.Data.MainList
import com.example.order.MainActivity
import com.example.order.R
import com.example.order.Repository.*
import com.example.order.ViewModel.MainViewModel
import com.example.order.app.App
import com.example.order.databinding.MainFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.main_fragment.*
import java.time.LocalDateTime
import java.util.*


class MainFragment : Fragment() {


    var repositoryResult: RepositoryMakeResult = RepositoryMakeResultImpl()
    private val localRepository1C: LocalRepository = LocalRepositoryImpl(App.get1CDAO())
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private var _binding: MainFragmentBinding? = null
    private val binding
        get() = _binding!!
    private val adapter = MainFragmentAdapter()
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        adapter.removeOnItemViewClickListener()


    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val etSearchBar=binding.inputEditText

        if (etSearchBar.requestFocus()) {
            (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(
                InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY
            )

        }
        val textView     = binding.inputEditTextDate
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month1 =month+1

        Keys.CURRENT_DATE= "$day.$month1.$year"

        textView.setText(Keys.DATE_OF_ORDER)
        input_date_layout.setEndIconOnClickListener {
            val dpd = DatePickerDialog(requireContext(), { _, year, _, dayOfMonth ->
                val month=month+1
                Keys.DATE_OF_ORDER="${addZeroToMonthAndDay(dayOfMonth)}.${addZeroToMonthAndDay(month)}.$year"
                /*viewModel.setDate("${addZeroToMonthAndDay(dayOfMonth)}.${addZeroToMonthAndDay(month)}.$year",textView)*/
                textView.setText(Keys.DATE_OF_ORDER)
            }, year, month, day)
            dpd.show()
        }



        setBottomSheetBehavior(view.findViewById(R.id.bottom_sheet_container))
        setBottomAppBar(view)
        hideAndShowDate()
         adapter.setOnItemViewClickListener(object : OnItemViewClickListener {
            override fun onItemViewClick(mainList: MainList) {
                if (count == KEY_FOR_INFLATE_MAIN_LIST) {
                    binding.inputEditTextDate.hide()
                    Keys.LIST_KEY = mainList.id2
                    count += 1
                    val manager = activity?.supportFragmentManager

                    makeDetails(manager, mainList)



                } else {
                    binding.inputEditTextDate.show()
                    count = KEY_FOR_INFLATE_MAIN_LIST
                    Keys.LIST_KEY = Keys.DEFAULT_VALUE
                    val manager = activity?.supportFragmentManager
                    repositoryResult.rememberMainList(mainList)

                    makeDetails(manager, mainList)

                }
            }

        })

        binding.mainFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.mainFragmentRecyclerView.adapter = adapter
        viewModel.getData().observe(viewLifecycleOwner, { renderList(it) })
        viewModel.getMainListViewModel()
        etSearchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateSearch()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main_botom_bar, menu)
    }

    private fun setBottomAppBar(view: View) {
        val context = activity as MainActivity
        context.setSupportActionBar(view.findViewById(R.id.bottom_bar_main))
        setHasOptionsMenu(true)

    }

    private fun setBottomSheetBehavior(bottomSheet: ConstraintLayout) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.send_main_bottom_bar) {
           // var dateFromCalendar= Keys.DEFAULT_MAINlIST
            if (Keys.DATE_OF_ORDER!= "") {
               val dateFromCalendar= MainList("date","date",Keys.CURRENT_DATE,Keys.DEFAULT_VALUE) // убрать хардкод из этой строки
                /*repositoryResult.rememberMainList(dateFromCalendar)*/
                Keys.MAIN_REMEMEBERED_LIST.add(dateFromCalendar)
            }


           /* if (viewModel.checkCompleteness(Keys.LIST_FOR_FIRST_SCREEN,Keys.MAIN_REMEMEBERED_LIST,Keys.DATE_OF_ORDER)=="Данные наряда заполнены не полностью"){
                toast("Данные наряда заполнены не полностью")
            }*/
           /* else {*/
                localRepository1C.putDataToResultDB(Keys.MAIN_REMEMEBERED_LIST)
                toast("данные записаны успешно")
              /*  viewModel.getFinishedOrdersFromServer()*/
               /* viewModel.pullDataToServer(localRepository1C.getAllDataDBResultEntity())*/
               /* viewModel.getData().observe(viewLifecycleOwner, { isDataUploadedToServer(it) })*/
             /* Keys.GLOBAL_LIST=Keys.DEFAULT_lIST*/
                Keys.LIST_FOR_FIRST_SCREEN = mutableListOf()
                Keys.MAIN_REMEMEBERED_LIST= mutableListOf()
                Keys.DATE_OF_ORDER= ""
                Keys.LIST_KEY=Keys.DEFAULT_VALUE
                goToSaveFragment(activity?.supportFragmentManager)











            }
      /*  }*/

        return super.onOptionsItemSelected(item)
    }


    private fun makeDetails(
        manager: FragmentManager?,
        mainList: MainList
    ) {
        if (manager != null) {
            val bundle = Bundle()
            bundle.putParcelable(DetailsFragment.BUNDLE_EXTRA, mainList)
            manager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(bundle))
                .addToBackStack("")
                .commitAllowingStateLoss()
        }
    }
    private fun updateSearch() {
        val etSearchBar=binding.inputEditText
        val s = etSearchBar.text
        if (s?.length == 0) {
            adapter.setMainList(viewModel.convertArrayListItemToMainList(ItemStorage.list))
        } else {
            adapter.setMainList( viewModel.convertArrayListItemToMainList(ItemStorage.list).filter {
                 it.name.contains(s.toString(), true)
            } )
        }

    }

    private fun renderList(data: AppState) {
        when (data) {
            is AppState.Success -> {
               adapter.setMainList(data.mainList)
                ItemStorage.list=viewModel.convertMainListToArrayListItem(data.mainList)
            }
            is AppState.Loading -> {
            }
            is AppState.Error -> {
                toast(data.error.message)

            }

        }

    }
    private fun isDataUploadedToServer(data: AppState) {
        when (data) {
            is AppState.Success -> {
             toast("Выгрузка прошла успешно")
            }
            is AppState.Loading -> {
            }
            is AppState.Error -> {
                toast(data.error.message)

            }

        }

    }

    interface OnItemViewClickListener {
        fun onItemViewClick(mainList: MainList)
    }

   private fun Fragment.toast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).apply {

            show()
        }
    }
    private fun addZeroToMonthAndDay(dayOrMonth:Int):String{
        return if (dayOrMonth <10) {
            "0$dayOrMonth"

        } else{
            dayOrMonth.toString()
        }

    }
    private fun hideAndShowDate(){
        val etSearchBar=binding.inputEditText
        if (count!= KEY_FOR_INFLATE_MAIN_LIST) {
            //второй экран
            if (etSearchBar.requestFocus()) {
                (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(
                    InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY
                )

            }
            binding.inputEditTextDate.isGone=true
            binding.bottomBarMain.isGone=true
            binding.inputLayout.isGone=false

            binding.inputDateLayout.endIconMode=TextInputLayout.END_ICON_NONE
            val params = binding.mainFragmentRecyclerView.layoutParams as ConstraintLayout.LayoutParams
            params.topToBottom=binding.inputLayout.id
            etSearchBar.inputType = InputType.TYPE_CLASS_PHONE;


        } else {
            //первый экран
            binding.inputDateLayout.isGone=true
            binding.inputLayout.isGone=false
            binding.bottomBarMain.isGone=false
            etSearchBar.inputType = InputType.TYPE_CLASS_TEXT;

        }
    }
    private fun goToSaveFragment(
        manager: FragmentManager?,

        ) {
        manager?.beginTransaction()?.replace(R.id.container, SaveFragment.newInstance())
            ?.addToBackStack("")?.commitAllowingStateLoss()
    }





    companion object {
        fun newInstance()= MainFragment()
        }
 }




