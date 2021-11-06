package com.example.smb2b

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("SELECT * FROM student")
    fun getStudents(): LiveData<List<Student>>

    @Insert
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

}