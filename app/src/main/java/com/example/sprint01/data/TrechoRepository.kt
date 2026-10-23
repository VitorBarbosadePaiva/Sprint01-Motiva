package com.example.sprint01.data

import android.content.Context
import com.example.sprint01.domain.TrechoRodovia
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TrechoRepository(context: Context) {
    private val prefs = context.getSharedPreferences("VegeTrackPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun salvarTrechos(trechos: List<TrechoRodovia>) {
        val json = gson.toJson(trechos)
        prefs.edit().putString("MEUS_TRECHOS", json).apply()
    }

    fun obterTrechos(): List<TrechoRodovia> {
        val json = prefs.getString("MEUS_TRECHOS", null)
        return if (json != null) {
            val type = object : TypeToken<List<TrechoRodovia>>() {}.type
            gson.fromJson(json, type)
        } else {
            val listaInicial = listOf(
                TrechoRodovia(1, "Km 45 - Rodovia Norte", "15/10/2026", "Verde", 15),
                TrechoRodovia(2, "Km 82 - Rodovia Sul", "10/10/2026", "Vermelho", 85)
            )
            salvarTrechos(listaInicial)
            listaInicial
        }
    }
}