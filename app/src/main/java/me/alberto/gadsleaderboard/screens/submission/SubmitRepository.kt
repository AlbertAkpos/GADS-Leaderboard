package me.alberto.gadsleaderboard.screens.submission

import me.alberto.gadsleaderboard.app.data.remote.source.submit.SubmitDataSource
import javax.inject.Inject

class SubmitRepository @Inject constructor(private val remoteDataSource: SubmitDataSource) {

    suspend fun submitProject(
        email: String,
        firstName: String,
        lastName: String,
        githubLink: String
    ) {
        remoteDataSource.submitProject(email, firstName, lastName, githubLink)
    }

}