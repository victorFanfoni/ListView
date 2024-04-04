package com.fiap.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val fabAddTask = findViewById<FloatingActionButton>(R.id.fabAddTask)

        val tasks = ArrayList<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        listView.adapter = adapter

        fabAddTask.setOnClickListener {
            // Inflar o layout do AlertDialog personalizado
            val dialogView = layoutInflater.inflate(R.layout.dialog_add_task, null)
            val editTextTaskName = dialogView.findViewById<EditText>(R.id.editTextTaskName)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Adicionar Tarefa")
                .setView(dialogView)
                .setPositiveButton("Adicionar") { dialog, _ ->
                    val newTask = editTextTaskName.text.toString()
                    if (newTask.isNotEmpty()) {
                        tasks.add(newTask)
                        adapter.notifyDataSetChanged()
                    }
                    dialog.dismiss()
                }
                .setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.dismiss()
                }

            builder.create().show()
        }
    }
}
