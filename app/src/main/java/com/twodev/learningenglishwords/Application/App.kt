package com.twodev.learningenglishwords.Application

import android.app.Application
import androidx.lifecycle.ViewModel
import com.twodev.learningenglishwords.di.dbModule
import com.twodev.learningenglishwords.di.repositoryModule
import com.twodev.learningenglishwords.di.viewModuleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    viewModuleModule,dbModule,repositoryModule,
                )
            )
        }

    }

    companion object {
        var instance: App? = null
    }
}