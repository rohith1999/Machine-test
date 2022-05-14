package com.demo.paging3withroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.paging3withroom.model.UserData

/**
 * @author Rohith S
 * AppDatabase helps in creation of room database
 */
@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getAppDao(): AppDao

    companion object{
        private  var DB_INSTANCE: AppDatabase? = null

        fun getAppDBInstance(context: Context):AppDatabase{
            if(DB_INSTANCE == null){
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "APP_DB"
                ).allowMainThreadQueries().build()
            }
            return  DB_INSTANCE!!;
        }

    }

}