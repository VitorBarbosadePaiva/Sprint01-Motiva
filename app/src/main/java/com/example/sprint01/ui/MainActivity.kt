package com.example.sprint01.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint01.R

class MainActivity : AppCompatActivity() {

    private val viewModel: TrechoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTrechos = findViewById<RecyclerView>(R.id.rvTrechos)
        val tvEstado = findViewById<TextView>(R.id.tvEstado)
        rvTrechos.layoutManager = LinearLayoutManager(this)

        viewModel.estado.observe(this) { estado ->
            when (estado) {
                is UiState.Carregando -> {
                    tvEstado.visibility = View.VISIBLE
                    rvTrechos.visibility = View.GONE
                }
                is UiState.Sucesso -> {
                    tvEstado.visibility = View.GONE
                    rvTrechos.visibility = View.VISIBLE

                    val adapter = TrechoAdapter(estado.trechos) { trechoSelecionado ->
                        val intent = android.content.Intent(this, DetalhesTrechoActivity::class.java)
                        intent.putExtra("NOME", trechoSelecionado.nome)
                        intent.putExtra("STATUS", trechoSelecionado.nivelAlerta)
                        intent.putExtra("CRESCIMENTO", trechoSelecionado.crescimentoVegetacao)
                        startActivity(intent)
                    }
                    rvTrechos.adapter = adapter
                }
                is UiState.Erro -> {
                    tvEstado.text = estado.mensagem
                    tvEstado.visibility = View.VISIBLE
                    rvTrechos.visibility = View.GONE
                    Toast.makeText(this, estado.mensagem, Toast.LENGTH_LONG).show()
                }
            }
        }

        viewModel.carregarDados(this)
    }
}