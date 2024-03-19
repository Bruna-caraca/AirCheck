package br.com.fiap.aircheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.aircheck.screens.AirQualityInfo
import br.com.fiap.aircheck.screens.HomeScreen
import br.com.fiap.aircheck.ui.theme.AirCheckTheme
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AirCheckTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "homescreen") {
                        composable(route = "homescreen") {
                            HomeScreen(navController)
                        }
                        composable(route = "info/{statusAirQuality}") {
                            val statusAirQuality: String? =
                                it.arguments?.getString("statusAirQuality", "")
                            AirQualityInfo(navController, statusAirQuality!!)
                        }
                    }
                }
            }
        }
    }
}