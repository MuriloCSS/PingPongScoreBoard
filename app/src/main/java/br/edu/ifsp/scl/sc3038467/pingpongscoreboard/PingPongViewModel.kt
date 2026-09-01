package br.edu.ifsp.scl.sc3038467.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PingPongViewModel : ViewModel(){

    private val _pontosA = MutableStateFlow(0)
    val pontosA: StateFlow<Int> = _pontosA.asStateFlow()

    private val _pontosB = MutableStateFlow(0)
    val pontosB: StateFlow<Int> = _pontosB.asStateFlow()


    fun addPontoA(){
        _pontosA.value++
    }

    fun addPontoB(){
        _pontosB.value++
    }

    fun resetJogo(){
        _pontosA.value = 0
        _pontosB.value = 0
    }

}