package com.learn.notesappyt.data.di

import com.learn.notesappyt.data.remote.NotesAPI
import com.learn.notesappyt.data.repository.NotesRepositoryImpl
import com.learn.notesappyt.domain.repository.NotesRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideNotesApi() : NotesAPI{
    return Retrofit.Builder()
        .baseUrl("http://192.168.201.121:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NotesAPI::class.java)

}

fun provideNotesRepository(notesAPI: NotesAPI) : NotesRepository {
    return NotesRepositoryImpl(notesAPI)
}

val DataModules = module {
    single { provideNotesApi() }

    single { provideNotesRepository(get()) }
}