package br.edu.ifsp.scl.sc3038467.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.savedState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PingPongViewModel(
    private val savedStateHandle: SavedStateHandle ) : ViewModel(){


    val pontosA: StateFlow<Int> = savedStateHandle.getStateFlow("pontosA", 0)
    val pontosB: StateFlow<Int> = savedStateHandle.getStateFlow("pontosB", 0)


    fun addPontoA(){
        val placarAtual = savedStateHandle.get<Int>("pontosA") ?: 0
        savedStateHandle["pontosA"] = placarAtual + 1
    }

    fun addPontoB(){
        val placarAtual = savedStateHandle.get<Int>("pontosB") ?: 0
        savedStateHandle["pontosB"] = placarAtual + 1
    }

    fun resetJogo(){
        savedStateHandle["pontosA"] = 0
        savedStateHandle["pontosB"] = 0
    }

}