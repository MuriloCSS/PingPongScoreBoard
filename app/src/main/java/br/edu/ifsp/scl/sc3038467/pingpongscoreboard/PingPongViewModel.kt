package br.edu.ifsp.scl.sc3038467.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PingPongViewModel : ViewModel(){

    var pontosA by mutableStateOf(0)
        private set

    var pontosB by mutableStateOf(0)
        private set

    fun addPontoA(){
        pontosA++
    }

    fun addPontoB(){
        pontosB++
    }

    fun resetJogo(){
        pontosA = 0
        pontosB = 0
    }

}