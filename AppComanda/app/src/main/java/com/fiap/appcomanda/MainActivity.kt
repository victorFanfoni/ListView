package com.fiap.appcomanda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.fiap.appcomanda.databinding.ActivityMainBinding


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
            // Pegando as quantidades inseridas pelo usuario
            val editTextQuantidadeCoxinha = findViewById<EditText>(R.id.editTextQuantidadeCoxinha)
            val editTextQuantidadeBebida = findViewById<EdiText>(R.id.editTextQuantidadeBebida)
            val QuantidadeCoxinha = editTextQuantidadeCoxinha.text.toString().toOrNull() ?: 0
            val quantidadeBebida = editTextQuantidadeBebida.text.toString().toOrNull() ?: 0

            // Calculando os precos
            val totalCoxinha = QuantidadeCoxinha * taxaServico
            val totalBebida = quantidadeBebida * taxaServico
            val totalProdutos = totalCoxinha + totalBebida

            val taxaServicovalor = totalProdutos * taxaServico
            val totalComTaxa = totalProdutos + taxaServicovalor

            // Passando os valores para segunda Tela
            val intent = Intent(this, segundaActivity::class.java)
            intent.putExtra("QuantidadeCoxinha", QuantidadeCoxinha)
            intent.putExtra("quantidadeBebida", quantidadeBebida)
            intent.putExtra("totalProdutos", totalProdutos)
            intent.putExtra("taxaServicoValor", taxaServicovalor)
            intent.putExtra("totalComTaxa",totalComTaxa)
            startActivity(intent)
        }
    }
}
