package br.com.fiap.aircheck.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.aircheck.R

enum class Status {
    Boa,
    Regular,
    Inadequada,
    Má,
    Péssima,
    Crítica
}
@Composable
fun CardAirQualityInfo(statusAirQuality: String, color: Int) {
    var statusEscale by remember {
        mutableStateOf("")
    }

    var textInfo by remember {
        mutableStateOf("")
    }

    when (statusAirQuality) {
        Status.Boa.toString() ->
            statusEscale = "0 - 50"
        Status.Regular.toString() ->
            statusEscale = "51 - 100"
        Status.Inadequada.toString() ->
            statusEscale = "101 - 150"
        Status.Má.toString() ->
            statusEscale = "151 - 200"
        Status.Péssima.toString() ->
            statusEscale = "201 - 300"
        Status.Crítica.toString() ->
            statusEscale = "300+"
    }

    when (statusAirQuality) {
        Status.Boa.toString() ->
            textInfo = "A qualidade do ar é considerada satisfatória e a poluição atmosférica representa pouco ou nenhum risco."
        Status.Regular.toString() ->
            textInfo = "A qualidade do ar é aceitável, no entanto, para alguns poluentes, pode haver um problema moderado de saúde para um número muito pequeno de pessoas que são invulgarmente sensíveis à poluição atmosférica."
        Status.Inadequada.toString() ->
            textInfo = "Membros de grupos sensíveis podem sofrer efeitos na saúde. O público em geral provavelmente não será afetado."
        Status.Má.toString() ->
            textInfo = "Todos podem começar a sentir efeitos na saúde; membros de grupos sensíveis podem sofrer efeitos mais graves para a saúde."
        Status.Péssima.toString() ->
            textInfo = "Advertências de saúde sobre condições de emergência. Toda a população tem maior probabilidade de ser afetada."
        Status.Crítica.toString() ->
            textInfo = "Alerta de saúde: todos podem sofrer efeitos mais graves para a saúde."
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = color)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = "$statusAirQuality ($statusEscale)",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = colorResource(id = R.color.white)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = textInfo,
//                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = colorResource(id = R.color.white)
            )
        }
    }
}