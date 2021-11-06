package com.example.smb2b

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.smb2b.databinding.ElementBinding

class CustomAdapter(private val studentViewModel: StudentViewModel
) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    private var listOfStudents = emptyList<Student>()

    class CustomViewHolder(val binding: ElementBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomAdapter.CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ElementBinding.inflate(inflater)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomAdapter.CustomViewHolder, position: Int) {
        val currentStudent = listOfStudents[position]
        holder.binding.tvName.text = currentStudent.name
        holder.binding.tvSurname.text = currentStudent.surname
        holder.binding.tvDelete.setOnClickListener {
            studentViewModel.delete(currentStudent)
        }
    }

    override fun getItemCount(): Int = listOfStudents.size

    fun setStudent(students: List<Student>){
        listOfStudents = students
        notifyDataSetChanged() //update po zmianie listy
    }

}