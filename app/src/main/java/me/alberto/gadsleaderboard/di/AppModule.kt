package me.alberto.gadsleaderboard.di

import dagger.Binds
import dagger.Module
import me.alberto.gadsleaderboard.app.data.remote.leader.LeaderRemoteDataSource
import me.alberto.gadsleaderboard.screens.learningleader.LeaderRemoteDataSourceImpl

@Module
abstract class AppModule {
    @Binds
    abstract fun provideLeaderDataSource(dataSourceImpl: LeaderRemoteDataSourceImpl): LeaderRemoteDataSource
}