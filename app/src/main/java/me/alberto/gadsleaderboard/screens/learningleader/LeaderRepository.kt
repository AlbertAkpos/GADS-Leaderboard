package me.alberto.gadsleaderboard.screens.learningleader

import me.alberto.gadsleaderboard.app.data.remote.source.leader.LeaderRemoteDataSource
import me.alberto.gadsleaderboard.app.data.remote.response.leaders
import javax.inject.Inject

class LeaderRepository @Inject constructor(private val remoteDataSource: LeaderRemoteDataSource) {
    suspend fun getLearnLeaders(): leaders = remoteDataSource.getLearnLeaders()
    suspend fun getSkillLeaders(): leaders = remoteDataSource.getSkillLeaders()
}