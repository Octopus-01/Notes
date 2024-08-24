package com.learn.notesappyt.presentation.home

import com.learn.notesappyt.domain.models.Notes

data class StateHomeScrreen(
    val gettingNotes : Boolean = false,
    val fetchNotes : List<Notes> ? = emptyList(),
    val error : String = ""
)