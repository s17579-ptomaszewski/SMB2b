package com.example.smb2b

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.smb2b.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sp = getPreferences(Context.MODE_PRIVATE)
        val editor = sp.edit()
        binding.bt2.setOnClickListener {
            val str = binding.et1.text.toString()
            binding.tv1.text = str
            editor.putString("str1", str)
            editor.apply()
        }

    }

    override fun onStart() {
        super.onStart()
        binding.tv1.text = sp.getString("str1", "Domyślna")
    }

    fun click(view: View) {
        val str = binding.et1.text.toString()
        //Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        val intentDrugieActivity = Intent(this, DrugieActivity::class.java)
        intentDrugieActivity.putExtra("userInput1", str)
        startActivity(intentDrugieActivity)
    }
}