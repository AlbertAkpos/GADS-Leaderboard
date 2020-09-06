package me.alberto.gadsleaderboard.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.alberto.gadsleaderboard.screens.learningleader.LeaderViewModel

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LeaderViewModel::class)
    abstract fun bindsLeaderViewModel(leaderViewModel: LeaderViewModel): ViewModel
}