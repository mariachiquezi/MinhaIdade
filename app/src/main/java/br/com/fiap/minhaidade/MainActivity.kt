package br.com.fiap.minhaidade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.minhaidade.ui.theme.MinhaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaIdadeTheme {
                Surface(
                    // fillMaxSize -> toda tela
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    MeuComponente()
                }
            }
        }
    }
}

@Composable
fun MeuComponente () {
    var idade = remember {
        mutableStateOf(
            0
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "Qual sua idade?",
            // colocar cores exadecimais (0x para inicializar, FF , depois realmente o valor da cor)
            color = Color(0xFF008B8B),
            // para texto usamos a syze sp (significa que a fonte é escalavel)
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            //modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(text = "Precione os botoes para informar sua idade ",
            fontSize = 17.sp,
            color =  Color.Black,
            textAlign = TextAlign.Center,
            //modifier = Modifier.fillMaxWidth()
            )

        // espaçamento de 25 dp antes
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "${idade.value}",
            fontSize = 48.sp,
            color = Color(0xFF00CED1),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.ExtraBold)
        // espaçamento de 25 dp depois
        Spacer(modifier = Modifier.height(25.dp))


            Row (horizontalArrangement = Arrangement.Center){
            Button(
                // oq deve acontecer quando o botao for precisonado
                onClick = {
                    // idade é um objeto mutavel entao temos que acessar o valor dela
                    idade.value--
                          },
                // mudar a forma do botao
                shape = RectangleShape,
                // para alterar a cor o botao temos essa funcao propria colors
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5F9EA0)),
                modifier = Modifier.size(84.dp)
            ) {
                Text(text = "-", fontSize = 40.sp)
            }
            // entre os dois botoes vamos colocar um espaçamento usando o spacer
            Spacer(modifier = Modifier.width(50.dp))
            Button(
                onClick = {
                    idade.value++
                    // log  de informação 
                    Log.i("Fiap", "MeuComponente: ${idade.value}")
                },
                shape = RectangleShape,
                modifier = Modifier.size(84.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5F9EA0)),) {
                Text(text = "+",  fontSize = 40.sp)


            }
        }
    }
    
}
// atralho prev + enter
@Preview (showSystemUi = true, showBackground = true)
@Composable
fun MeuComponentePreview () {
    MeuComponente()
    
}