package com.example.sprint01.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sprint01.R

class DetalhesTrechoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_trecho)

        // Recebe os dados que vieram do clique na lista
        val nome = intent.getStringExtra("NOME")
        val status = intent.getStringExtra("STATUS")
        val crescimento = intent.getIntExtra("CRESCIMENTO", 0)

        // Preenche a interface visual
        findViewById<TextView>(R.id.tvDetalheNome).text = nome
        findViewById<TextView>(R.id.tvDetalheStatus).text = "Alerta IA: $status"
        findViewById<TextView>(R.id.tvDetalheCrescimento).text = "Crescimento Vegetação: $crescimento%"

        // Configura o botão
        findViewById<Button>(R.id.btnIniciarManutencao).setOnClickListener {
            Toast.makeText(this, "Manutenção registada!", Toast.LENGTH_SHORT).show()
            finish() // Fecha este ecrã e volta para a lista
        }
    }
}