package br.com.fiap.aircheck.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.aircheck.R
import br.com.fiap.aircheck.colorCardByStatus
import br.com.fiap.aircheck.components.CardAirQualityInfo

@Composable
fun AirQualityInfo(navController: NavController, statusAirQuality: String) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(color = colorResource(id = R.color.blueLight))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_air_check),
                    contentDescription = "Logo aplicativo",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(top = 16.dp)
                        .offset(y = (-5).dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "AirCheck",
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white),
                    fontSize = 20.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            CardAirQualityInfo(statusAirQuality = statusAirQuality, color = colorCardByStatus(statusAirQuality))
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = {
                    navController.navigate("homescreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue))
            ) {
                Text(text = "Voltar")
            }
        }
    }
}



