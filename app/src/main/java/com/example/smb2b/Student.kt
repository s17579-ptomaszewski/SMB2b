package com.example.smb2b

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String,
    var surname: String,
    var isGraduate: Boolean
)