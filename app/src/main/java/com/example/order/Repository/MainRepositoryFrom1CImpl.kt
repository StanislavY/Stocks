package com.example.order.Repository

import com.example.order.Data.Keys

import com.example.order.Data.MainList
import com.example.order.ViewModel.Database1CViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class MainRepositoryFrom1CImpl:MainRepisitoryFrom1C {
    private val repository: RepositoryGetMainList = RepositoryGetMainListImpl()

    private val dataBase1CViewModel: Database1CViewModel = Database1CViewModel()

/*
    private val hoursWorked=makeListOfWork(Keys.NUMBERS_OF_VALUES_FOR_WORKED_HOURS,Keys.STEP_FOR_WORKED_HOURS,"Отработано часов")
*/

    // саделать маски для имен в главном списке
    override fun getListForChoice(): List<MainList> {

        val dataFrom1C: List<MainList>
        val listOfHerbs:MutableList<MainList> = mutableListOf(
            MainList("АбрикосЛистЦеликом","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Адамов кореньКорниЧипсы","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Чипсы"),
            MainList("Аир болотныйКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("АкацияЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("АнисПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("АрникаЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("БарбарисКорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("БерезаПочкаЦеликом","Почка","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("БессмертникЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("БолиголовТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Боровая МаткаТраваЦеликом","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("БоярышникПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("БузинаКорниСтружка","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Стружка"),
            MainList("БузинаПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("БузинаЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Бузина травянистаяКорниРучная резка","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("БуквицаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ВалерианаКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ВасилекЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ВербенаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ВерескТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Витекс священныйПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ВишняЛистЦеликом","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Водный перецТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ВолодушкаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Волчье лыкоКораЦеликом","Кора","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ВорсянкаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ГармалаТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("Гингко БилобаЛистДробленая (7-9 мм)","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Горец змеиныйКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Горечавка перекрестнолистнаяТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Грецкий орехЛистЦеликом","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ГрушанкаТраваЦеликом","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Грыжник серыйТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ДевясилКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ДиоскореяКорниЧипсы","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Чипсы"),
            MainList("ДонникТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ДубКораДробленая (7-9 мм)","Кора","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ДурнишникТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ДушицаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ДымянкаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ДягильКорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЕжевикаПобегЦеликом","Побег","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЗимолюбкаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЗмеевикКорницелый","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","целый"),
            MainList("Золототысячник","0","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","0"),
            MainList("ЗюзникТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ИваКораЦеликом","Кора","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Исландский мохМохЦеликом","Мох","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ИссопТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("КалганКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("КалендулаЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Касатик (ирис болотный)КорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("КаштанПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Кинза (кориандр)ПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("КлеверЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Клубника садоваяЛистДробленая (7-9 мм)","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Конский щавельКорниЧипсы","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Чипсы"),
            MainList("КопытеньКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("КоровякТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("КрапиваТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("КрапиваТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("Красная щеткаКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Красный кореньКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("КрушинаКораДробленая (7-9 мм)","Кора","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("КубышкаКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Кукольник (Чемерица)КорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Кукурузные рыльцаРыльцаЦеликом","Рыльца","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Лабазник шестилепестковыйКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Лапчатка белаяКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЛевзеякорниДробленая (7-9 мм)","корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЛевзеяКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЛенПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЛещинаЛистДробленая (7-9 мм)","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЛипаЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЛопухКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЛюбистокКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЛюцернаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("МалинаЛистцелый","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","целый"),
            MainList("МанжеткаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Марена красильнаяКорницелая","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","целая"),
            MainList("Мать-и-мачехаЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Мать-и-мачехаЛистЦеликом","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("МедуницаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("МелиссаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("МелиссаТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("МожжевельникПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("МокрицаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("МордовникПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("МорковьПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("МорозникКорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("МорозникКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Мята перечнаяТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Мята полеваяТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ОдуванчикКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ОдуванчикТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ОкопникКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ОмелаТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ОмелаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ОртосифонТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ОсинаКораДробленая (7-9 мм)","Кора","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ПажитникПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ПижмаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ПижмаТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ПионКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Подмаренник цепкийТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ПодорожникЛист","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","0"),
            MainList("ПодсолнухКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ПодсолнухКорниРучная резка","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("Пол-полаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ПолыньТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ПустырникТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ПырейКорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("РасторопшаПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("РепешокТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("РепешокТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("РододендронЛистЦеликом","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Роза чайнаяЛепесткиЦеликом","Лепестки","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("РозмаринТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("РомашкаЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Рябина краснаяПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Рябина черноплодная (арония)ПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("СассапарильКорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("СеннаЛистЦеликом","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("СнытьТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("СолодкаКорниРучная резка","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("СолодкаКорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("СоснаПочкаЦеликом","Почка","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Софора японскаяПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("Софора японскаяЦветЦеликом","Цвет","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("СтальникТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("СтальникКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("СтевияТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("СурепкаТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("СухоцветТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("СушеницаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Таволга вязолистаяТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Таволга вязолистаяТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ТатарникТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ТеренКорниСтружка","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Стружка"),
            MainList("ТминПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ТолокнянкаЛистЦеликом","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ТутовникЛистДробленая (7-9 мм)","Лист","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ТысячелистникТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ТысячелистникТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("УкропПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ФасольСтворкиЦеликом","Створки","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ФенхельПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ХвощТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЦикорийТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЦикорийКорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЧабрецТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЧагаГрибЦеликом","Гриб","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЧередаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЧередаТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ЧерникаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЧернобыльникКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЧистецТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЧистотелТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Шалфей дикийТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Шалфей дикийТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("Шалфей эфиопский (лекарственный)ТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Шалфей эфиопский (лекарственный)ТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ШикшаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ШиповникКорниСтружка","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Стружка"),
            MainList("ШиповникПлодыЦеликом","Плоды","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ШлемникКорниЦеликом","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Целиком"),
            MainList("ЭхинацеяТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ЭхинацеяТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("Якорцы стелющиесяТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЯруткаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЯруткаТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ЯсноткаТраваДробленая (7-9 мм)","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)"),
            MainList("ЯсноткаТраваРучная резка","Трава","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Ручная резка"),
            MainList("ЯтрышникКорниДробленая (7-9 мм)","Корни","Keys.DEFAULD_VALUE_FOR_GENERATED_LIST","Дробленая (7-9 мм)")


        )
/*
        val quality:MutableList<MainList> = mutableListOf(
            MainList("ДоплатаЗаКачество","Доплата за качество 0%","0",Keys.DEFAULD_VALUE_FOR_GENERATED_LIST),
            MainList("ДоплатаЗаКачество","Доплата за качество 20%","20",Keys.DEFAULD_VALUE_FOR_GENERATED_LIST)
        )
        val difficult:MutableList<MainList> = mutableListOf(
            MainList("ДоплатаЗаТяжесть(Сложность)","ДоплатаЗаКачество0%","0",Keys.DEFAULD_VALUE_FOR_GENERATED_LIST),
            MainList("ДоплатаЗаТяжесть(Сложность)","ДоплатаЗаКачество12%","12",Keys.DEFAULD_VALUE_FOR_GENERATED_LIST)
        )
        val refill:MutableList<MainList> = mutableListOf(
            MainList("ДоплатаЗаЗаправку","ДоплатаЗаЗаправку0%","0",Keys.DEFAULD_VALUE_FOR_GENERATED_LIST),
            MainList("ДоплатаЗаЗаправку","ДоплатаЗаЗаправку20%","20",Keys.DEFAULD_VALUE_FOR_GENERATED_LIST)
        )
        val weekends:MutableList<MainList> = mutableListOf(
            MainList("ДоплатаЗаВыходные","ДоплатаЗаВыходные0%","0",Keys.DEFAULD_VALUE_FOR_GENERATED_LIST),
            MainList("ДоплатаЗаВыходные","ДоплатаЗаВыходные100%","100",Keys.DEFAULD_VALUE_FOR_GENERATED_LIST)
        )*/
        val generalListOfHerbs=makeListOfHerbs(1000,1.0,listOfHerbs)

        if (Keys.LIST_KEY != "0") {
            dataFrom1C = Keys.LIST_FROM_DB

        }
        else {

            dataFrom1C = dataBase1CViewModel.getAllDataFromDB1C()
            Keys.LIST_FROM_DB=dataFrom1C

        }
/*
        testListBrigadir=makeListFromDB("ФизическиеЛица",dataFrom1C)
              testListTrakctorDriver=makeListFromDB("ФизическиеЛица",dataFrom1C)*/

        val startList=makeStartList(dataFrom1C+generalListOfHerbs
               )+dataFrom1C+generalListOfHerbs
        Keys.GLOBAL_LIST=startList

        return /*setDefaultValues(startList)*/startList
    }
    private fun makeListFromDB(key: String, list:List<MainList>): List<MainList> {
        val tempList: MutableList<MainList> = mutableListOf()
        for (mainList in list) {
            if (mainList.id1 == key) {
                tempList.add(mainList)
            }
        }
        for (mainList in tempList) {
             mainList.value = mainList.name

                }





        return tempList.distinctBy { it.name to it.id1 to it.id2 }


    }

    private fun makeStartList(mainList: List<MainList>): List<MainList> {
        val startList: List<MainList> = mainList.distinctBy { it.id1 }
        val convertList:MutableList<MainList> = mutableListOf()
         for (startList1 in startList) {
           convertList.add(changeValues(startList1.id1,startList1.id2,startList1.name,startList1.value))

        }
        return convertList
    }

    fun changeValues (id1:String, id2:String, name: String, value:String):MainList{
        val objectForChange = MainList(id1,id2,name,value)

        objectForChange.name=objectForChange.id1
        objectForChange.id2=objectForChange.id1
        objectForChange.id1="0"
        return objectForChange
    }
   /* private fun makeListOfWork(numberOfValues:Int, step:Double, nameOfField:String):MutableList<MainList>{
        val workList: MutableList<MainList> = mutableListOf()
        var valueForWork=0.000
        for (i in 1..numberOfValues){
            valueForWork += step
            val roundedNumber = DecimalFormat("#.###")
            roundedNumber.roundingMode = RoundingMode.CEILING

            workList.add(MainList(nameOfField,roundedNumber.format(valueForWork).toString(),roundedNumber.format(valueForWork).toString(),Keys.DEFAULD_VALUE_FOR_GENERATED_LIST))
        }
        return workList

    }*/

    private fun makeListOfHerbs(numberOfValues:Int, step:Double,listOfHerbs:List<MainList>):MutableList<MainList>{
        val workList: MutableList<MainList> = mutableListOf()

        var valueForWork=0.000
        for (herb in listOfHerbs) {

            for (i in 1..numberOfValues){
                valueForWork += step
                val roundedNumber = DecimalFormat("#.#")
                roundedNumber.roundingMode = RoundingMode.CEILING

                workList.add(MainList(herb.id1,roundedNumber.format(valueForWork).toString(),roundedNumber.format(valueForWork).toString(),Keys.DEFAULT_VALUE_FOR_GENERATED_LIST))

            }
            valueForWork=0.000

        }

        return workList

    }
  /*  private fun setDefaultValues(startList: List<MainList>):List<MainList>{
        val listDefaultFromDB: List<MainList> = dataBase1CViewModel.getAllDataFromResultDB()
        for (mainList in startList) {
            for (listDefault in listDefaultFromDB){
                if (mainList.id1 == listDefault.id1) {
                    mainList.name=listDefault.name


                }

            }

        }
        return startList



    }*/

}










