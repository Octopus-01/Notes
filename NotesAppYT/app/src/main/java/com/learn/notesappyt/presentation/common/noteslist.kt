package com.learn.notesappyt.presentation.common

import com.learn.notesappyt.domain.models.Notes

data class Notes(
    val noteTitle: String,
    val noteDescription: String,
    val notePriority: String,
    val date : String = "12-01-2000"
)

val noteslist = listOf(
    Notes(
        notesTitle = "Meeting Notes",
        notesDescription = "Discussed the new project roadmap, assigned tasks to team members, and set deadlines.",
        notesPriority = "High",
        date = "17-08-2024"
    ),
    Notes(
        notesTitle = "Vacation Itinerary",
        notesDescription = "Plan for the 5-day trip to Hawaii, including flights, hotel reservations, and sightseeing tours.",
        notesPriority = "High",
        date = "13-08-2024"
    ),
    Notes(
        notesTitle = "Grocery List",
        notesDescription = "Buy vegetables, fruits, milk, and bread from the supermarket. Remember to check for discounts.",
        notesPriority = "Medium",
        date = "16-08-2024"
    ),
    Notes(
        notesTitle = "Workout Plan",
        notesDescription = "Complete a 30-minute cardio session, followed by strength training focusing on legs and core.",
        notesPriority = "High",
        date = "15-08-2024"
    ),
    Notes(
        notesTitle = "Book Summary",
        notesDescription = "Summarize key takeaways from the book 'Atomic Habits' by James Clear.",
        notesPriority = "Low",
        date = "14-08-2024"
    ),
)