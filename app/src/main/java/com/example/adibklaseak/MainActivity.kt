package com.example.adibklaseak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adibklaseak.models.Datuak
import com.example.adibklaseak.models.Pertsonaiak
import com.example.adibklaseak.ui.theme.AdibKlaseakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdibKlaseakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PertsonaiakZerrenda(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PertsonaiakZerrenda(modifier: Modifier = Modifier) {
    val pertsonaia = Datuak().pertsonaiakZerrenda()
    LazyColumn(modifier = Modifier) {
        items(pertsonaia){ pertsonaiak -> PertsonaiaZerranda(pertsonaiak) }
    }
}
@Composable
fun PertsonaiaZerranda(pertsonaiak: Pertsonaiak, modifier: Modifier = Modifier) {
        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(pertsonaiak.irudia),
                    contentDescription = "Ginyu",
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = pertsonaiak.izena,
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Ki: ${pertsonaiak.ki}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Max Ki: ${pertsonaiak.maxKi}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdibKlaseakTheme {
        PertsonaiakZerrenda()
    }
}