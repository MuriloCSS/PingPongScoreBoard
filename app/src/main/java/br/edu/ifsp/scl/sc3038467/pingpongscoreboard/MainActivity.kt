package br.edu.ifsp.scl.sc3038467.pingpongscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.scl.sc3038467.pingpongscoreboard.ui.theme.PingPongScoreBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PingPongScoreBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PingPongScore(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PingPongScore(modifier: Modifier = Modifier, viewModel: PingPongViewModel = viewModel()) {

    val pontosA by viewModel.pontosA.collectAsState()
    val pontosB by viewModel.pontosB.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).safeDrawingPadding()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            Column(modifier = Modifier.fillMaxSize().weight(1f)) {

                Text(text ="Jogador A", fontSize = 32.sp, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 42.dp)
                )

                Text(text = "${pontosA}", fontSize = 64.sp ,modifier = Modifier
                    .padding(top = 64.dp)
                    .align(Alignment.CenterHorizontally)

                )

                Button({
                    viewModel.addPontoA()
                }, modifier = Modifier
                    .width(128.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 96.dp))
                {
                    Text("+1 ponto")
                }
            }
            Column(modifier = Modifier.fillMaxSize().weight(1f)) {

                Text(text ="Jogador B", fontSize = 32.sp, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 42.dp)
                )

                Text(text = "${pontosB}", fontSize = 64.sp ,modifier = Modifier
                    .padding(top = 64.dp)
                    .align(Alignment.CenterHorizontally)

                )

                Button({
                    viewModel.addPontoB()
                }, modifier = Modifier
                    .width(128.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 96.dp))
                {
                    Text("+1 ponto")
                }
            }
        }
        Button({
            viewModel.resetJogo()
        }, modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)


        ) {
            Text("Reiniciar Partida")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PingPongScorePreview() {
    PingPongScoreBoardTheme {
        PingPongScore()
    }
}