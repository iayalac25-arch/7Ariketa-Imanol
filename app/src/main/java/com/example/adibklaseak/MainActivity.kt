package com.example.adibklaseak

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adibklaseak.models.Datuak
import com.example.adibklaseak.models.Pertsonaiak
import com.example.adibklaseak.ui.theme.AdibKlaseakTheme
import kotlinx.serialization.json.Json

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
    val context = LocalContext.current
    val pertsonaiaLista = datuakKargatu(context, "pertsonaiak.json")

    LazyColumn(modifier = modifier) {
        items(pertsonaiaLista) { pertsonaia ->
            PertsonaiaTxartela(pertsonaia = pertsonaia)
        }
    }
}

fun datuakKargatu(context: Context, fitx: String): List<Pertsonaiak> {
    return try {
        val jsonString = context.assets.open(fitx)
            .bufferedReader()
            .use { it.readText() }

        Log.d("EL string: ", jsonString)

        Json { ignoreUnknownKeys = true }
            .decodeFromString<List<Pertsonaiak>>(jsonString)
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}

@Composable
fun PertsonaiaTxartela(pertsonaia: Pertsonaiak, modifier: Modifier = Modifier) {
    val irudia = when (pertsonaia.irudia.lowercase()) {
        "dodoria" -> R.drawable.dodoria
        "freezer" -> R.drawable.freezer
        "ginyu" -> R.drawable.ginyu
        else -> R.drawable.zarbon
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = irudia),
                contentDescription = pertsonaia.name,
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = pertsonaia.name,
                    fontSize = 20.sp,
                    lineHeight = 22.sp
                )
                Text(
                    text = "Ki: ${pertsonaia.ki}",
                    fontSize = 20.sp,
                    lineHeight = 22.sp
                )
                Text(
                    text = "Max Ki: ${pertsonaia.maxKi}",
                    fontSize = 20.sp,
                    lineHeight = 22.sp
                )
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