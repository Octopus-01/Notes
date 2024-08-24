package com.learn.notesappyt.domain.repository

import com.learn.notesappyt.domain.models.Notes
import com.learn.notesappyt.presentation.util.Resourse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NotesRepository {

    suspend fun saveNotes(notes: Notes): Flow<Resourse<String>>

    suspend fun getNotes() : Flow<Resourse<List<Notes>>>

}