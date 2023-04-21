package com.example.n_rise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.n_rise.n_rise.common.Constants.PARAM_PROGRAM_ID
import com.example.n_rise.n_rise.presentation.Screen
import com.example.n_rise.n_rise.presentation.program_detail.ProgramDetailScreen
import com.example.n_rise.n_rise.presentation.program_list.ProgramListScreen
import com.example.n_rise.ui.theme.N_riseTheme
import com.example.n_rise.ui.theme.nRiseTypography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            N_riseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ProgramListScreen.route
                    ) {
                        composable(route = Screen.ProgramListScreen.route) {
                            ProgramListScreen(navController = navController)
                        }
                        composable(route = Screen.ProgramDetailScreen.route + "?${PARAM_PROGRAM_ID}={${PARAM_PROGRAM_ID}}",
                            arguments = listOf(
                                navArgument(
                                    name = PARAM_PROGRAM_ID
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            ProgramDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        style = nRiseTypography.h20,
        color = Color.White


    )
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    N_riseTheme {
        Greeting("Android")
    }
}