package com.learn.notesappyt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.learn.notesappyt.R
import com.learn.notesappyt.presentation.nav_host.SetUpNavHost
import com.learn.notesappyt.presentation.ui.theme.NotesAppYTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize the splash screen

        installSplashScreen()
        setContent {
            NotesAppYTTheme {
                val systemUiController = rememberSystemUiController()

                // Set status bar color
                systemUiController.setStatusBarColor(
                    colorResource(id = R.color.blue),
                    darkIcons = true // Adjust based on your theme
                )

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.light_blue))
                ){
                    SetUpNavHost()
                }
            }
        }
    }
}

