package com.tamersarioglu.izmirlist

import android.app.Application
import com.tamersarioglu.izmirlist.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoreApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoreApp)
            modules(appModule)
        }
    }
}