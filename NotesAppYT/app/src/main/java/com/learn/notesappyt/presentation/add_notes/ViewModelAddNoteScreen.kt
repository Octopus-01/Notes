package com.learn.notesappyt.presentation.add_notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.notesappyt.domain.models.Notes
import com.learn.notesappyt.domain.repository.NotesRepository
import com.learn.notesappyt.presentation.util.Resourse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModelAddNoteScreen : ViewModel() , KoinComponent{
    private val notesRepository : NotesRepository by inject()

    private val _stateNote = MutableStateFlow(StateAddNoteScreen())
    val noteState = _stateNote

    private fun saveNotes(notes : Notes) {
        viewModelScope.launch {
            notesRepository.saveNotes(notes).collect { resourse ->
                when (resourse) {
                    is Resourse.Loding ->{
                        _stateNote.value = noteState.value.copy(savingNotes = true)
                    }
                    is Resourse.Success ->{
                        _stateNote.value = noteState.value.copy(
                            notesSaved = resourse.data.toString()
                        )
                    }
                    is Resourse.Error ->{
                        _stateNote.value = noteState.value.copy(
                            notesError = resourse.message.toString()
                        )
                    }
                }
            }
        }
    }
    fun onEvent(event : EventAddNoteScreen){
        when(event){
            is EventAddNoteScreen.NoteTitle -> {
                _stateNote.value = noteState.value.copy(notesTitle = event.title)
            }

            is EventAddNoteScreen.NoteDescription -> {
                _stateNote.value = noteState.value.copy(
                    noteDescription = event.description
                )

            }
            is EventAddNoteScreen.NotePriority -> {
                _stateNote.value = _stateNote.value.copy(
                    notePriority = event.priority
                )
            }

            is EventAddNoteScreen.SaveNotes -> {
                saveNotes(event.notes)

            }
        }
    }
}