package com.example.sprint01.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint01.R
import com.example.sprint01.data.SimuladorIA

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Localiza a lista no XML
        val rvTrechos = findViewById<RecyclerView>(R.id.rvTrechos)

        // Define que a lista será na vertical
        rvTrechos.layoutManager = LinearLayoutManager(this)

        // Pega os dados falsos do simulador
        val simulador = SimuladorIA()
        val listaDeTrechos = simulador.obterTrechosMonitorizados()

        // Conecta os dados à lista usando o Adapter
        // Conecta os dados à lista e programa a navegação (Intent)
        val adapter = TrechoAdapter(listaDeTrechos) { trechoSelecionado ->
            val intent = android.content.Intent(this, DetalhesTrechoActivity::class.java)
            // Empacota os dados para enviar para o ecrã de detalhes
            intent.putExtra("NOME", trechoSelecionado.nome)
            intent.putExtra("STATUS", trechoSelecionado.nivelAlerta)
            intent.putExtra("CRESCIMENTO", trechoSelecionado.crescimentoVegetacao)
            startActivity(intent)
        }
        rvTrechos.adapter = adapter
    }
}