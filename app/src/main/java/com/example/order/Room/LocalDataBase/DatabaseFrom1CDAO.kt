package com.example.order.Room.LocalDataBase

import android.database.Cursor
import androidx.room.*

@Dao
interface DatabaseFrom1CDAO {

        @Query("SELECT*FROM DatabaseFrom1CEntity")
        fun all1C():List<DatabaseFrom1CEntity>


        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun insert(entity: DatabaseFrom1CEntity)

        @Update
        fun update(entity: DatabaseFrom1CEntity)

        @Delete
        fun delete (entity: DatabaseFrom1CEntity)

        @Query("DELETE FROM DatabaseFrom1CEntity")
        fun deleteall()

        @Query("SELECT id1, id2, name FROM DatabaseFrom1CEntity")
        fun getHistoryCursor(): Cursor

        @Query("SELECT id1, id2, name FROM DatabaseFrom1CEntity WHERE id1 = :id1&id2=:id2")
        fun getHistoryCursor(id1: Int,id2:Int): Cursor

        @Query("SELECT*FROM ResultEntity WHERE value=0")
        fun getAllUnfinishedResult():List<ResultEntity>
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun insertDataToResult(entity: ResultEntity)





}
