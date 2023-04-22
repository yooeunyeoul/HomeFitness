package com.example.n_rise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.n_rise.n_rise.common.Constants.PARAM_CATEGORY_NAME
import com.example.n_rise.n_rise.common.Constants.PARAM_COACH_NAME
import com.example.n_rise.n_rise.common.Constants.PARAM_IMAGE_URL
import com.example.n_rise.n_rise.common.Constants.PARAM_PROGRAM_ID
import com.example.n_rise.n_rise.common.Constants.PARAM_TITLE
import com.example.n_rise.n_rise.domain.model.Program
import com.example.n_rise.n_rise.presentation.Screen
import com.example.n_rise.n_rise.presentation.program_detail.ProgramDetailScreen
import com.example.n_rise.n_rise.presentation.program_list.ProgramListScreen
import com.example.n_rise.n_rise.presentation.util.ProgramArgType
import com.example.n_rise.ui.theme.N_riseTheme
import com.example.n_rise.ui.theme.nRiseTypography
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson
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
                        composable(route = Screen.ProgramDetailScreen.route+"/{${PARAM_IMAGE_URL}}/{${PARAM_CATEGORY_NAME}}/{${PARAM_COACH_NAME}}/{${PARAM_TITLE}}",
                            arguments = listOf(
                                navArgument(
                                    name = PARAM_TITLE
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                },
                                navArgument(
                                    name = PARAM_IMAGE_URL
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                },
                                navArgument(
                                    name = PARAM_CATEGORY_NAME
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }, navArgument(
                                    name = PARAM_COACH_NAME
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) { entry ->
                            val imageUrl = entry.arguments?.getString(PARAM_IMAGE_URL) ?: ""
                            val coach = entry.arguments?.getString(PARAM_COACH_NAME) ?: ""
                            val category = entry.arguments?.getString(PARAM_CATEGORY_NAME) ?: ""
                            val title = entry.arguments?.getString(PARAM_TITLE) ?: ""
                            ProgramDetailScreen(
                                navController = navController,
                                Program(
                                    image_url = imageUrl,
                                    coachName = coach,
                                    category = category,
                                    title = title
                                )
                            )
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