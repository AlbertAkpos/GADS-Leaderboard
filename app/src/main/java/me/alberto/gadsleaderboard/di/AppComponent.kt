package me.alberto.gadsleaderboard.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.alberto.gadsleaderboard.activity.HostActivity
import me.alberto.gadsleaderboard.di.viewmodel.ViewModelModule
import me.alberto.gadsleaderboard.fragment.HostFragment
import me.alberto.gadsleaderboard.screens.learningleader.LearnLeaderFragment
import me.alberto.gadsleaderboard.screens.submission.SubmissionFragment

@Component(modules = [NetworkModule::class, AppModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: LearnLeaderFragment)
    fun inject(activity: HostActivity)
    fun inject(fragment: HostFragment)
    fun inject(fragment: SubmissionFragment)
}