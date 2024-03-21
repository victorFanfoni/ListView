package com.fiap.navegacao

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class SegundaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_segunda)

        val quantidadeCoxinha = intent.getIntExtra("quantidadeCoxinha", 0)
        val quantidadeBebida = intent.getIntExtra("quantidadeBebida", 0)
        val totalProdutos = intent.getDoubleExtra("totalProdutos", 0.0)
        val taxaServicoValor = intent.getDoubleExtra("taxaServicoValor", 0.0)
        val totalComTaxa = intent.getDoubleExtra("totalComTaxa", 0.0)

        val textViewQuantidadeCoxinha = findViewById<TextView>(R.id.textViewQuantidadeCoxinha)
        textViewQuantidadeCoxinha.text = "Quantidade de Coxinhas: $quantidadeCoxinha"

        val textViewQuantidadeBebida = findViewById<TextView>(R.id.textViewQuantidadeBebida)
        textViewQuantidadeBebida.text = "Quantidade de Bebidas: $quantidadeBebida"

        val textViewSoma = findViewById<TextView>(R.id.textViewSoma)
        textViewSoma.text = "Soma dos Produtos: R$ $totalProdutos"

        val textViewTaxa = findViewById<TextView>(R.id.textViewTaxa)
        textViewTaxa.text = "Taxa de Serviço (10%): R$ $taxaServicoValor"

        val textViewTotal = findViewById<TextView>(R.id.textViewTotal)
        textViewTotal.text = "Total a Pagar: R$ $totalComTaxa"

        val buttonVoltar = findViewById<Button>(R.id.btVoltar)
        buttonVoltar.setOnClickListener {
            finish() // Retorna para a activity anterior
        }
    }
}
