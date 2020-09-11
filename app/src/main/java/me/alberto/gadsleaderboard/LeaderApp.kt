package me.alberto.gadsleaderboard

import android.app.Application
import me.alberto.gadsleaderboard.di.AppComponent
import me.alberto.gadsleaderboard.di.DaggerAppComponent

class LeaderApp : Application() {
    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)

    }
}