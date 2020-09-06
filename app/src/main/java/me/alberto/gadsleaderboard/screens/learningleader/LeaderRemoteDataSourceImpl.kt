package me.alberto.gadsleaderboard.screens.learningleader

import me.alberto.gadsleaderboard.app.data.remote.api.Api
import me.alberto.gadsleaderboard.app.data.remote.leader.LeaderRemoteDataSource
import me.alberto.gadsleaderboard.app.data.remote.response.leaders
import javax.inject.Inject

class LeaderRemoteDataSourceImpl @Inject constructor(private val api: Api) :
    LeaderRemoteDataSource {
    override suspend fun getLearnLeaders(): leaders {
        return api.getHoursLeaders()
    }

    override suspend fun getSkillLeaders(): leaders {
        return api.getSkillIQLeaders()
    }
}