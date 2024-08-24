package com.learn.notesappyt.presentation.home
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.learn.notesappyt.R
import com.learn.notesappyt.domain.models.Notes
import com.learn.notesappyt.presentation.common.AppToolBar
import com.learn.notesappyt.presentation.common.NotesCard
import com.learn.notesappyt.presentation.nav_host.AddNotesScreen


@Composable
fun HomeScreen(
    navController: NavHostController,
    state : StateHomeScrreen,
    modifier: Modifier = Modifier)
{
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            AppToolBar(title = "Notes")

            if (isnoteFetched(state)){
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalItemSpacing = 8.dp

                ) {
                    items(state.fetchNotes!!) {
                        NotesCard(notes = it)
                    }
                }
            }
        }


        FloatingActionButton(
            onClick = { navController.navigate(AddNotesScreen) }, // use the correct route string
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
            containerColor = colorResource(id = R.color.blue)
        ) {
            Icon(
                Icons.Filled.Add, // Use your add icon resource
                contentDescription = "Add Note",
                tint = colorResource(id = R.color.ultra_dark_blue)
            )
        }
    }
}

fun isnoteFetched(state: StateHomeScrreen): Boolean {
    return when{
        state.gettingNotes -> false
        state.fetchNotes!!.isNotEmpty() -> true
        else -> {false}
    }

}
