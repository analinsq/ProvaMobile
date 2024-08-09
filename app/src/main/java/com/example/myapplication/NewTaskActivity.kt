package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class NewTaskActivity : AppCompatActivity() {

    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)

        val et_title: TextInputEditText = findViewById(R.id.et_title)
        val et_description: TextInputEditText = findViewById(R.id.et_description)
        val bt_save: MaterialButton = findViewById(R.id.bt_save)

        bt_save.setOnClickListener {
            val title = et_title.text.toString()
            val description = et_description.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty()) {
                val task = Task(title = title, description = description)
                taskViewModel.insert(task)
                Toast.makeText(this, "Atividade criada com sucesso :)", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
