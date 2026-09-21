package com.example.sprint01.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint01.R
import com.example.sprint01.domain.TrechoRodovia

class TrechoAdapter(
    private val trechos: List<TrechoRodovia>,
    private val aoClicarNoTrecho: (TrechoRodovia) -> Unit
) : RecyclerView.Adapter<TrechoAdapter.TrechoViewHolder>() {

    class TrechoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNome: TextView = view.findViewById(R.id.tvNomeTrecho)
        val tvStatus: TextView = view.findViewById(R.id.tvStatusIA)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrechoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trecho, parent, false)
        return TrechoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrechoViewHolder, position: Int) {
        val trecho = trechos[position]
        holder.tvNome.text = trecho.nome
        holder.tvStatus.text = "Alerta da IA: ${trecho.nivelAlerta}"

        // Ativa o clique no cartão inteiro
        holder.itemView.setOnClickListener {
            aoClicarNoTrecho(trecho)
        }
    }

    override fun getItemCount(): Int = trechos.size
}