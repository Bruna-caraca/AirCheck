package br.com.fiap.aircheck.screens

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.aircheck.R

@Composable
fun HomeScreen() {

    var cidade by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
            ) {
                Card(
                    modifier = Modifier
                        .offset(y = (-10).dp)
                        .fillMaxWidth(),
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
                                color = colorResource(id = R.color.white),
                                textAlign = TextAlign.Left
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
                        }

                    }
                }
            }
        }
    }
}