package com.learn.notesappyt.domain.models

data class Notes(
    val notesTitle : String,
    val notesDescription : String,
    val notesPriority : String,
    val date : String = "12-01-2000"

)