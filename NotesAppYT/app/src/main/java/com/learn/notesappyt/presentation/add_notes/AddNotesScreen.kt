package com.learn.notesappyt.presentation.add_notes

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.learn.notesappyt.R
import com.learn.notesappyt.domain.models.Notes
import com.learn.notesappyt.presentation.common.AppOutlinedTextField
import com.learn.notesappyt.presentation.common.AppToolBar
import com.learn.notesappyt.presentation.common.CustomFilterChip
import com.learn.notesappyt.presentation.nav_host.HomeScreen


/*@Composable
@Preview
fun Preview(){
    AddNotesScreen(navController = rememberNavController())
}*/

@Composable
fun AddNotesScreen(
    navController: NavController,
    state : StateAddNoteScreen,
    event : (EventAddNoteScreen) -> Unit){
    Box(modifier = Modifier
        .fillMaxSize()){

        Column {

            AppToolBar(title = "Add Note" ,
                navigationIcon = Icons.AutoMirrored.Default.ArrowBack,
                onNavigationClick = {
                    // Back to home
                    navController.navigate(HomeScreen)
                    {
                        popUpTo(HomeScreen)
                        {
                            inclusive = true
                        }
                    }
                })
            Column(modifier = Modifier.padding(8.dp))
            {

                Spacer(modifier = Modifier.height(20.dp))

                AppOutlinedTextField(
                    value = state.notesTitle,
                    onValueChange = {
                        tata->
                            event(EventAddNoteScreen.NoteTitle(tata))
                    },
                    maxLines = 2,
                    lable = "Add Title"
                )

                Spacer(modifier = Modifier.height(30.dp))

                AppOutlinedTextField(
                    value = state.noteDescription,
                    onValueChange = {
                        desc->
                            event(EventAddNoteScreen.NoteDescription(desc))
                    },
                    maxLines = 10,
                    height = 300.dp,
                    lable = "Add Note"
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.End)
                ) {
                    CustomFilterChip(
                        lable = "Low",
                        color = Color.Green,
                        selected = state.notePriority == "Low",
                        onClick = {
                            event(EventAddNoteScreen.NotePriority("Low"))
                        })
                    CustomFilterChip(
                        lable = "Medium",
                        color = Color.Yellow,
                        selected = state.notePriority == "Medium",
                        onClick = {
                            event(EventAddNoteScreen.NotePriority("Medium"))
                        })
                    CustomFilterChip(
                        lable = "High",
                        color = Color.Red,
                        selected = state.notePriority == "High",
                        onClick = {
                            event(EventAddNoteScreen.NotePriority("High"))
                        })

                }
            }
        }

        FloatingActionButton(
            onClick = {
                //Log.d("Notes Detail", "${state.notesTitle}, ${state.noteDescription}, ${state.notePriority}")
                val notes = Notes(
                    notesTitle = state.notesTitle,
                    notesDescription = state.noteDescription,
                    notesPriority = state.notePriority
                )
                event(EventAddNoteScreen.SaveNotes(notes))
                navController.navigate(HomeScreen)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
            containerColor = colorResource(id = R.color.blue)
        ) {
            Icon(
                Icons.Filled.Done, // Use your add icon resource
                contentDescription = "Add",
                tint = colorResource(id = R.color.ultra_dark_blue)
            )
        }
        LaunchedEffect(state) {
            when{
                state.savingNotes ->{
                    Log.d("Notes Detail", "Loading....")
                }
                state.notesSaved == "Note saved" ->{
                    Log.d("Notes Detail", "Notes saved")
                    navController.navigate(HomeScreen)
                    {
                        popUpTo(HomeScreen)
                        {
                            inclusive = true
                        }
                    }
                }
                state.notesError == "error" ->{
                    Log.d("Notes Detail", "Notes  not saved")

                }
            }
        }
    }
}