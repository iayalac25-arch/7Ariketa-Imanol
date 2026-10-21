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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adibklaseak.models.Pertsonaiak
import com.example.adibklaseak.ui.theme.AdibKlaseakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdibKlaseakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PertsonaiaZerranda(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PertsonaiaZerranda(modifier: Modifier = Modifier) {
    val ginyu = Pertsonaiak("Ginyu", 500, 10000)
    val dodaria = Pertsonaiak("Dodaria", 300, 9000)
    val zarbon = Pertsonaiak("Zarbon", 350, 7000)
    val freezer = Pertsonaiak("Freezer", 800, 13000)

    Column(modifier = modifier.fillMaxSize()) {
        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ginyu),
                    contentDescription = "Ginyu",
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = ginyu.izena,
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Ki: ${ginyu.ki}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Max Ki: ${ginyu.maxKi}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.dodoria),
                    contentDescription = "Dodaria",
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = dodaria.izena,
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Ki: ${dodaria.ki}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Max Ki: ${dodaria.maxKi}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.zarbon),
                    contentDescription = "Zarbon",
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = zarbon.izena,
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Ki: ${zarbon.ki}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Max Ki: ${zarbon.maxKi}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.freezer),
                    contentDescription = "Freezer",
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = freezer.izena,
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Ki: ${freezer.ki}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                    Text(
                        text = "Max Ki: ${freezer.maxKi}",
                        fontSize = 20.sp,
                        lineHeight = 22.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdibKlaseakTheme {
        PertsonaiaZerranda()
    }
}