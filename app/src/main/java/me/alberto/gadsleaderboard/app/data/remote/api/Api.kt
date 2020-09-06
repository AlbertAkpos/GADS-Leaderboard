package me.alberto.gadsleaderboard.app.data.remote.api

import me.alberto.gadsleaderboard.app.data.remote.response.leaders
import retrofit2.http.GET

interface Api {

    @GET("/api/hours")
    suspend fun getHoursLeaders(): leaders

    @GET(" /api/skilliq")
    suspend fun getSkillIQLeaders(): leaders
}