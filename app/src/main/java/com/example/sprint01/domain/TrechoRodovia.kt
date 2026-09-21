package com.example.sprint01.domain

data class TrechoRodovia(
    val id: Int,
    val nome: String,
    val ultimaInspecao: String,
    val nivelAlerta: String, // Pode ser "Verde", "Amarelo" ou "Vermelho"
    val crescimentoVegetacao: Int // Em percentagem
)