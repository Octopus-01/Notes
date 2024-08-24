package com.learn.notesappyt.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.notesappyt.R
import com.learn.notesappyt.domain.models.Notes

@Composable
fun NotesCard(
    modifier: Modifier = Modifier,
    notes: Notes
) {
    val chipColors = remember(notes.notesPriority) {
        when(notes.notesPriority){
            "Medium" -> Color.Yellow
            "High" -> Color.Red
            else -> Color.Green

        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.blue))
    ){
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.blue)),
            modifier = modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(8.dp))
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    CustomFilterChip(
                        lable = notes.notesPriority,
                        color = chipColors,
                        alphaValue = 0.4f,
                        selected = false){}

                }
                Text(
                    text = notes.notesTitle,
                    color = colorResource(id = R.color.ultra_dark_blue),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = notes.notesDescription,
                    color = colorResource(id = R.color.light_blue),
                    fontSize = 15.sp,)

                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = notes.date,
                    color = colorResource(id = R.color.ultra_light_blue),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.End
                )

            }

        }

    }
}