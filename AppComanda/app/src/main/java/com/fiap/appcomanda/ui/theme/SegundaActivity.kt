package com.fiap.appcomanda.ui.theme

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity


class SegundaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda_tela)

        val QantidadeCoxinha = intent.getIntExtra("quantidadeCoxina", 0)
        val quantidadebebida = intent.getIntExtra("quantidadeBebida", 0)
        val totalProdutos = intent.getIntExtra("totalProdutos", 0.0)
        val taxaServicovalor = intent.getIntExtra("totalServicoValor", 0.0)
        val totalComTaxa = intent.getIntExtra("totalComTaxa", 0.0)

        val textViewQuantidadeCoxinha = findViewById<TextView>(R.id.textViewQuantidadeCoxinha)
        textViewQuantidadeCoxinha.text = "Quantidade de Coxinhas: $QantidadeCoxinha"

        val textViewQuantidadeBebida = findViewById<TextView>(R.id.textViewQuantidadeBebida)
        textViewQuantidadeBebida.text = "Quantidade de Bebidas: $quantidadebebida"

        val textViewSoma = findViewById<TextView>(R.id.textViewSoma)
        textViewSoma.text = "Soma dos produtos: R$ $totalProdutos"

        val taxa = findViewById<TextView>(R.id.textViewTaxa)
        taxa.text = "Taxa de Servico(10%): R$ $taxaServicovalor"

        val total = findViewById<TextView>(R.id.textViewTotal)
        total.text = "Total a Pagar: R$ $totalComTaxa"

        val buttonVoltar = findViewById<Button>(R.id.btVoltar)
        buttonVoltar.setOnClickListener{
            finish()
        }

    }
}