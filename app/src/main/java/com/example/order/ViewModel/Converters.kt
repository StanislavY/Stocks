package com.example.order.ViewModel

import androidx.lifecycle.ViewModel
import com.example.order.Data.Item
import com.example.order.Data.Keys
import com.example.order.Data.MainList
import com.example.order.Room.LocalDataBase.DatabaseFrom1CEntity
import com.example.order.Room.LocalDataBase.ResultEntity
import com.example.order.Server.ServerResponseData
import java.util.*
import kotlin.collections.ArrayList

open class Converters : ViewModel() {
    fun converterFromResponseServerToMainList(serverResponse: List<ServerResponseData?>): List<MainList> {
        val convertedList: MutableList<MainList> = mutableListOf()

        for (list in serverResponse) {
            if (list != null) {
                convertedList.add(convertmakeMainListFromStrings(list.id1,list.id2,list.name))
            }

        }

        return convertedList

    }
    private fun convertmakeMainListFromStrings (id1:String?, id2:String?, name:String?):MainList{
        return MainList(id1!!,id2!!,name!!,Keys.DEFAULD_VALUE_FOR_GENERATED_LIST)

    }
    fun convertMainListToEntityDB1C(id1:String, id2:String, name: String, value:String): DatabaseFrom1CEntity {
        val databaseFrom1CEntity= DatabaseFrom1CEntity("","","","")
        databaseFrom1CEntity.id1=id1
        databaseFrom1CEntity.id2=id2
        databaseFrom1CEntity.name=name
        databaseFrom1CEntity.value=value
        return databaseFrom1CEntity
    }
    fun convertEntityDB1CToMainList(entityList: List<DatabaseFrom1CEntity>): List<MainList> {
        return entityList.map {
            MainList(it.id1, it.id2, it.name, it.value)

        }



    }
    fun convertEntityResultToMainList(entityList: List<ResultEntity>):List<MainList>{
        return entityList.map {  MainList(it.id1, it.id2, it.name, it.uid) }
    }
    fun convertRemListToResultEntity(remList:List<MainList>):List<ResultEntity>{
        val uid=UUID.randomUUID().toString()
        return remList.map { ResultEntity(it.id1,it.id2,it.name,it.value,uid

        ) }

    }
    fun convertMainlistToItemStorage(mainList:List<MainList>):ArrayList<Item>{
        val arrListOfItemStorage= ArrayList<Item>()
        for (mainList in mainList) {
            arrListOfItemStorage.add(Item(mainList.id1,mainList.id2,mainList.name,mainList.value))


        }
        return arrListOfItemStorage


    }


    fun convertItemStorageToMainList(arrayList:ArrayList<Item>):List<MainList>{
        val mainList= mutableListOf<MainList>()
        for (item in arrayList) {
            mainList.add(MainList(item.id1.toString(),item.id2.toString(),item.name.toString(),item.value.toString()))


        }
        return mainList

        }


}



