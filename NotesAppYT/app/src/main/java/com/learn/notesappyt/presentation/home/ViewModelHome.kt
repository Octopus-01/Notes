package com.learn.notesappyt.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.notesappyt.domain.repository.NotesRepository
import com.learn.notesappyt.presentation.util.Resourse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModelHome : ViewModel() , KoinComponent {

    private val notesRepository : NotesRepository by inject()

    private val _getNotesState = MutableStateFlow(StateHomeScrreen())
    val getNotesState = _getNotesState

    init {
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            notesRepository.getNotes().collect{resource->
                when(resource){
                    is Resourse.Success ->{
                        _getNotesState.value = _getNotesState.value.copy(fetchNotes = resource.data, gettingNotes = false)
                    }
                    is Resourse.Loding -> {
                        _getNotesState.value = _getNotesState.value.copy(gettingNotes = true)
                    }
                    is Resourse.Error -> {
                        _getNotesState.value = _getNotesState.value.copy(error = resource.message!!,gettingNotes = true)
                    }
                }

            }
        }

    }
}