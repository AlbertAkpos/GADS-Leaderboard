package me.alberto.gadsleaderboard.app.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    abstract class FeatureFailure : Failure()
}