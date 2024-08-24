package com.learn.notesappyt.presentation.add_notes

import com.learn.notesappyt.domain.models.Notes

sealed class EventAddNoteScreen {

    data class NoteTitle(val title : String) : EventAddNoteScreen()
    data class NoteDescription(val description : String) : EventAddNoteScreen()
    data class NotePriority(val priority : String) : EventAddNoteScreen()
    data class SaveNotes(val notes : Notes) : EventAddNoteScreen()
}