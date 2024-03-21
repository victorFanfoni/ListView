package com.fiap.aplication

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View?) {
                Toast.makeText(this, "Botao apertado.", Toast.LENHT_SHORT).show()
            }
        })
    }
}