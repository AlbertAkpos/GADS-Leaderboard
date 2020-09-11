package me.alberto.gadsleaderboard.di

import dagger.Binds
import dagger.Module
import me.alberto.gadsleaderboard.app.data.remote.source.leader.LeaderRemoteDataSource
import me.alberto.gadsleaderboard.app.data.remote.source.submit.SubmitDataSource
import me.alberto.gadsleaderboard.screens.learningleader.LeaderRemoteDataSourceImpl
import me.alberto.gadsleaderboard.screens.submission.SubmitDataSourceImpl

@Module
abstract class AppModule {
    @Binds
    abstract fun provideLeaderDataSource(dataSourceImpl: LeaderRemoteDataSourceImpl): LeaderRemoteDataSource

    @Binds
    abstract fun provideSubmitDataSource(submitDataSourceImpl: SubmitDataSourceImpl): SubmitDataSource
}