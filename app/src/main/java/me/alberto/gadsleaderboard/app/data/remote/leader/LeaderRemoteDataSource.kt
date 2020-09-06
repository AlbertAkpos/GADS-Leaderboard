package me.alberto.gadsleaderboard.app.data.remote.leader

import me.alberto.gadsleaderboard.app.data.remote.response.leaders


interface LeaderRemoteDataSource {
    suspend fun getLearnLeaders(): leaders
    suspend fun getSkillLeaders(): leaders
}