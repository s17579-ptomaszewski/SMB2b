package com.example.smb2b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smb2b.R
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smb2b.databinding.ActivityDrugieBinding
import com.example.smb2b.databinding.ActivityMainBinding

class DrugieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrugieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrugieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val tv = findViewById<TextView>(R.id.tv2)
        //tv.text = intent.getStringExtra("userInput1")

        binding.rv1.layoutManager = LinearLayoutManager(this)
        binding.rv1.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        val studentViewModel = StudentViewModel(application)

        val adapter = CustomAdapter(studentViewModel)

        binding.rv1.adapter = adapter

        studentViewModel.allStudents.observe(this, Observer {
            it.let{
                adapter.setStudent(it)
            }
        })

        binding.btDodaj.setOnClickListener {
            val student = Student(
                name = binding.etName.text.toString(),
                surname = binding.etSurname.text.toString(),
                isGraduate = true
            )
            studentViewModel.insert(student)
        }


    }
}