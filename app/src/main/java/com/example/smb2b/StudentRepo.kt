package com.example.smb2b

class StudentRepo(private val studentDao: StudentDao) {

    val allStudents = studentDao.getStudents()

    fun insert(student: Student) = studentDao.insert(student)

    fun delete(student: Student) = studentDao.delete(student)

}