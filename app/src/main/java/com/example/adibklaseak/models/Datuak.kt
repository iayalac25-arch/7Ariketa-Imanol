package com.example.adibklaseak.models

import com.example.adibklaseak.R

class Datuak {
    fun pertsonaiakZerrenda(): List<Pertsonaiak> {
         return listOf(
             Pertsonaiak("Ginyu", "500", "10000", "ginyu"),
             Pertsonaiak("Dodaria", "300", "9000", "dodoria"),
             Pertsonaiak("Zarbon", "350", "7000", "zarbon"),
             Pertsonaiak("Freezer", "800", "13000", "freezer")
         )
    }
}