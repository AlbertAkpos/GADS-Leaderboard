package me.alberto.gadsleaderboard.app.data.remote.source.submit

interface SubmitDataSource {
    suspend fun submitProject(
        email: String,
        firstName: String,
        lastName: String,
        githubLink: String
    )
}