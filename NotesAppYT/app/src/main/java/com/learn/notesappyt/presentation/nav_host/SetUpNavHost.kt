package com.learn.notesappyt.presentation.nav_host

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.notesappyt.presentation.add_notes.AddNotesScreen
import com.learn.notesappyt.presentation.add_notes.ViewModelAddNoteScreen
import com.learn.notesappyt.presentation.home.HomeScreen
import com.learn.notesappyt.presentation.home.ViewModelHome
import org.koin.androidx.compose.koinViewModel


@Composable
fun SetUpNavHost(){

    val navController  = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen) {

        composable<HomeScreen>{
            val viewModel : ViewModelHome = koinViewModel()
            val state by viewModel.getNotesState.collectAsState()
            HomeScreen(
                navController,
                state = state
            )
        }

        composable<AddNotesScreen>{

            val viewModel : ViewModelAddNoteScreen = koinViewModel()
            val state by viewModel.noteState.collectAsState()

            AddNotesScreen(
                navController,
                state = state,
                event = viewModel::onEvent)
        }

    }
}