package br.com.fiap.aircheck.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.aircheck.R
import br.com.fiap.aircheck.colorCard
import br.com.fiap.aircheck.components.CardAirQuality
import br.com.fiap.aircheck.components.CardError
import br.com.fiap.aircheck.model.AirQualityResponse
import br.com.fiap.aircheck.pollutionLevel
import br.com.fiap.aircheck.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun HomeScreen(navController: NavController) {

    var cidade by remember {
        mutableStateOf("")
    }

    var cidadeResponse by remember {
        mutableStateOf("")
    }

    var colorAirQuality by remember {
        mutableIntStateOf(R.color.gray)
    }

    var aqi by remember {
        mutableIntStateOf(-1)
    }

    var statusAirQuality by remember {
        mutableStateOf("")
    }

    var info by remember {
        mutableStateOf(false)
    }

    var error by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .offset(y = (-10).dp)
                        .fillMaxWidth()
                        .height(360.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.blueLight)),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(vertical = 16.dp, horizontal = 32.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            painter = painterResource(id = R.drawable.logo_air_check),
                            contentDescription = "Logo aplicativo",
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 16.dp)
                        )
                        Text(
                            text = "AirCheck",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Column {
                            Text(
                                text = "Cidade",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(id = R.color.white)
                            )
                            OutlinedTextField(
                                value = cidade,
                                onValueChange = {
                                    cidade = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Digite a cidade...")
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.white),
                                    focusedBorderColor = colorResource(id = R.color.blue),
                                    cursorColor = colorResource(id = R.color.blue),

                                    ),
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {
                                    val call = RetrofitFactory().getAirQualityService().getAirQualityByCity(cidade)
                                    call.enqueue(object : Callback<AirQualityResponse>{
                                        override fun onResponse(
                                            call: Call<AirQualityResponse>,
                                            response: Response<AirQualityResponse>
                                        ) {
                                            if(response.isSuccessful) {
                                                val airQualityResponse = response.body()
                                                if(airQualityResponse != null) {
                                                    aqi = airQualityResponse.data.aqi
                                                    cidadeResponse = airQualityResponse.data.city.name
                                                    statusAirQuality = pollutionLevel(aqi)
                                                    colorAirQuality = colorCard(aqi)
                                                    info = true
                                                }
                                            }

                                        }

                                        override fun onFailure(
                                            call: Call<AirQualityResponse>,
                                            t: Throwable
                                        ) {
                                            error = true
                                            Log.i("API", "error: ${t.message}")
                                        }

                                    })
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue))
                            ) {
                                Text(
                                    text = "Buscar",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
            if(info) {
            CardAirQuality(
                cidade = cidadeResponse,
                color = colorAirQuality,
                aqi = aqi,
                status = statusAirQuality
            )
                Button(
                    onClick = {
                        navController.navigate("info/$statusAirQuality")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue))
                ) {
                    Text(text = "Saiba Mais")
                }
            }
            if(error) {
                CardError()
            }
        }
    }
}
