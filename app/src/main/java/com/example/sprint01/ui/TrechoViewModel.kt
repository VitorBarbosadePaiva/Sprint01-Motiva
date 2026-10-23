package com.example.sprint01.ui

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sprint01.data.TrechoRepository
import com.example.sprint01.domain.TrechoRodovia

sealed class UiState {
    object Carregando : UiState()
    data class Sucesso(val trechos: List<TrechoRodovia>) : UiState()
    data class Erro(val mensagem: String) : UiState()
}

class TrechoViewModel : ViewModel() {
    private val _estado = MutableLiveData<UiState>()
    val estado: LiveData<UiState> get() = _estado

    fun carregarDados(context: Context) {
        _estado.value = UiState.Carregando

        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val repository = TrechoRepository(context)
                val dados = repository.obterTrechos()
                _estado.value = UiState.Sucesso(dados)
            } catch (e: Exception) {
                _estado.value = UiState.Erro("Falha ao carregar a base de dados.")
            }
        }, 2000)
    }
}