package com.example.pandasoft

import android.app.Application
import com.example.pandasoft.di.applicationModule
import com.example.pandasoft.util.PreferenceData
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(applicationModule)
            androidLogger()
        }
    }
}