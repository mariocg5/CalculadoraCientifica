package com.example.calculadoracientifica

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class HistorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        // Obtener el historial desde el intent
        val historial = intent.getStringArrayListExtra("HISTORIAL") ?: arrayListOf()

        // Configurar el ListView para mostrar el historial
        val listViewHistorial = findViewById<ListView>(R.id.listViewHistorial)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, historial)
        listViewHistorial.adapter = adapter

        val botonVolver = findViewById<Button>(R.id.botonVolver)
        botonVolver.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a la calculadora
        }
    }
}