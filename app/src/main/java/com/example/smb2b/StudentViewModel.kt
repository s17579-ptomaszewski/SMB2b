package com.example.smb2b

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class StudentViewModel(application: Application): AndroidViewModel(application) {

    private val repo: StudentRepo
    val allStudents: LiveData<List<Student>>

    init{
        repo = StudentRepo(StudentDB.getDatabase(application.applicationContext).studentDao())
        allStudents = repo.allStudents
    }

    fun insert(student: Student) = repo.insert(student)

    fun delete(student: Student) = repo.delete(student)

}