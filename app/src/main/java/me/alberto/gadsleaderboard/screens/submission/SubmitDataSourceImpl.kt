package me.alberto.gadsleaderboard.screens.submission

import me.alberto.gadsleaderboard.app.data.remote.api.SubmitApi
import me.alberto.gadsleaderboard.app.data.remote.source.submit.SubmitDataSource
import javax.inject.Inject

class SubmitDataSourceImpl @Inject constructor(private val api: SubmitApi) : SubmitDataSource {
    override suspend fun submitProject(
        email: String,
        firstName: String,
        lastName: String,
        githubLink: String
    ) {
        api.submitProject(email, firstName, lastName, githubLink)
    }
}