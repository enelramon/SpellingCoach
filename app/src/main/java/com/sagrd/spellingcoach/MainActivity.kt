package com.sagrd.spellingcoach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sagrd.spellingcoach.ui.theme.SpellingCoachTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sagrd.spellingcoach.ui.words.WordsListScreen
import com.sagrd.spellingcoach.util.Screen
import com.sagrd.spellingcoach.util.WordScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoachApp()
        }
    }
}

@Composable
fun CoachApp(
) {
    SpellingCoachTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController( )

            NavHost(navController = navHostController, startDestination = Screen.WordsListScreen.route){
                composable(route =Screen.WordsListScreen.route ){
                    WordsListScreen(
                       onNavigateToWord =  {navHostController.navigate(Screen.WordScreen.route)}
                    )
                }
                composable(route =Screen.WordScreen.route ){
                    WordScreen(
                        onSave={
                            navHostController.navigateUp()
                        }
                    )
                }
            }
        }
    }
}

