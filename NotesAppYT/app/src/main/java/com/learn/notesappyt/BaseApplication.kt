package com.learn.notesappyt

import android.app.Application
import com.learn.notesappyt.data.di.DataModules
import com.learn.notesappyt.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(presentationModule , DataModules)
            androidContext(this@BaseApplication)
        }
    }
}