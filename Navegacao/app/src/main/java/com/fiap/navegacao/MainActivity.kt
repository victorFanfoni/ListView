package com.fiap.navegacao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.fiap.navegacao.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private val precoCoxinha = 10.00
    private val precoBebida = 15.00
    private val taxaServico = 0.10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonCalcular = findViewById<Button>(R.id.btCalcular)
        buttonCalcular.setOnClickListener {

            val editTextQuantidadeCoxinha = findViewById<EditText>(R.id.QuantidadeCoxinha)
            val editTextQuantidadeBebida = findViewById<EditText>(R.id.QuantidadeBebida)

            val quantidadeCoxinha = editTextQuantidadeCoxinha.text.toString().toIntOrNull() ?: 0
            val quantidadeBebida = editTextQuantidadeBebida.text.toString().toIntOrNull() ?: 0

            val totalCoxinha = quantidadeCoxinha * precoCoxinha
            val totalBebida = quantidadeBebida * precoBebida
            val totalProdutos = totalCoxinha + totalBebida

            val taxaServicoValor = totalProdutos * taxaServico
            val totalComTaxa = totalProdutos + taxaServicoValor

            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("quantidadeCoxinha", quantidadeCoxinha)
            intent.putExtra("quantidadeBebida", quantidadeBebida)
            intent.putExtra("totalProdutos", totalProdutos)
            intent.putExtra("taxaServicoValor", taxaServicoValor)
            intent.putExtra("totalComTaxa", totalComTaxa)
            startActivity(intent)
        }
    }
}
