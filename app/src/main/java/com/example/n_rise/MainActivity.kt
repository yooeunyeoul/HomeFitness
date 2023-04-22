package com.example.n_rise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.n_rise.n_rise.presentation.Screen
import com.example.n_rise.n_rise.presentation.program_detail.ProgramDetailScreen
import com.example.n_rise.n_rise.presentation.program_list.ProgramListScreen
import com.example.n_rise.n_rise.presentation.util.toProgramModel
import com.example.n_rise.ui.theme.N_riseTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.JsonParser
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

                    val systemUiController = rememberSystemUiController()

                    SideEffect {
                        systemUiController.setStatusBarColor(color = Color.Black)
                    }
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ProgramListScreen.route
                    ) {
                        composable(route = Screen.ProgramListScreen.route) {
                            ProgramListScreen(navController = navController)
                        }
                        composable(route = Screen.ProgramDetailScreen.route + "/{encodeUrl}",
                            arguments = listOf(
                                navArgument(
                                    name = "encodeUrl"
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) { entry ->
                            val imageUrl = entry.arguments?.getString("encodeUrl") ?: ""
                            val jsonObject = JsonParser().parse(imageUrl).asJsonObject

                            ProgramDetailScreen(
                                navController = navController,
                                program = jsonObject.toProgramModel()
                            )
                        }
                    }
                }
            }
        }
    }
}