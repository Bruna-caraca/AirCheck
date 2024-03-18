package br.com.fiap.aircheck

fun pollutionLevel(aqi: Int): String {
    return if(aqi in 0..50) {
        "Boa"
    } else if(aqi in 51..100) {
        "Regular"
    } else if(aqi in 101..150) {
        "Inadequada"
    } else if(aqi in 151..200) {
        "Má"
    } else if(aqi in 201..300) {
        "Péssima"
    } else {
        "Crítica"
    }
}

fun colorCard(aqi: Int): Int {
    return if(aqi in 0..50) {
        R.color.green
    } else if(aqi in 51..100) {
        R.color.yellow
    } else if(aqi in 101..150) {
        R.color.orange
    } else if(aqi in 151..200) {
        R.color.red
    } else if(aqi in 201..300) {
        R.color.purple
    } else {
        R.color.darkRed
    }
}