package com.learn.notesappyt.presentation.add_notes

data class StateAddNoteScreen(

    val savingNotes : Boolean = false,
    val notesSaved : String = "",
    val notesError : String = "",

    val notesTitle : String = "",
    val noteDescription : String = "",
    val notePriority : String = "Low",
)