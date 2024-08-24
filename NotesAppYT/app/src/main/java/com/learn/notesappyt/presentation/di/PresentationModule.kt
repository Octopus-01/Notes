package com.learn.notesappyt.presentation.di

import com.learn.notesappyt.presentation.add_notes.ViewModelAddNoteScreen
import com.learn.notesappyt.presentation.home.ViewModelHome
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        ViewModelAddNoteScreen()
    }
    viewModel{
        ViewModelHome()
    }
}