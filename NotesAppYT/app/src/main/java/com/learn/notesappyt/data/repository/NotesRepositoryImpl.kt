package com.learn.notesappyt.data.repository

import com.learn.notesappyt.data.remote.NotesAPI
import com.learn.notesappyt.domain.models.Notes
import com.learn.notesappyt.domain.repository.NotesRepository
import com.learn.notesappyt.presentation.util.Resourse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NotesRepositoryImpl(
    private val notesAPI : NotesAPI
) : NotesRepository {
    override suspend fun saveNotes(notes: Notes): Flow<Resourse<String>> = flow{
        emit(Resourse.Loding())

        val status   = notesAPI.saveNotes(notes).code()

        try {
            if (status == 201) {
                emit(Resourse.Success("Note saved"))
            }
            else{
                emit(Resourse.Error("Unable to save note"))
            }
        }
        catch (e : Exception){
            emit(Resourse.Error(e.message))
        }
    }

    override suspend fun getNotes(): Flow<Resourse<List<Notes>>> = flow{
        val status = notesAPI.getNotes().code()
        try {
            val notesList = notesAPI.getNotes().body()
            if (status == 200) {
                emit(Resourse.Success(notesList))
            }
            else{
                emit(Resourse.Error("Unable to get note"))
            }
        }
        catch (e : Exception){
            emit(Resourse.Error(e.message))
        }
    }
}