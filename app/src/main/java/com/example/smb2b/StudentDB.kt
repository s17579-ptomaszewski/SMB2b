package com.example.smb2b

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDB: RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object{
        private var instance: StudentDB? = null

        fun getDatabase(context: Context): StudentDB{
            if(instance != null)
                return instance!!
            instance = Room.databaseBuilder(
                context,
                StudentDB::class.java,
                "StudentDatabase"
            ).allowMainThreadQueries().build()
            return instance!!
        }
    }

}