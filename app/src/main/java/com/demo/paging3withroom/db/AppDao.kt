package com.demo.paging3withroom.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.paging3withroom.model.UserData

/**
 * @author Rohith S
 * AppDao maps all sql queries to respective functions
 */
@Dao
interface AppDao {

    /**
     * getAllRecords - Gets all records from Room database
     */
    @Query("SELECT * FROM userdata")
    fun getAllRecords(): LiveData<List<UserData>>


    /**
     * insertRecords - Inserts a record into Room Database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(userData: UserData)


    /**
     * deleteAllRecords - Deletes all records from room database
     */
    @Query("DELETE FROM userdata")
    fun deleteAllRecords()
}