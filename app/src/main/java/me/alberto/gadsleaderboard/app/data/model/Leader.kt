package me.alberto.gadsleaderboard.app.data.model

import com.google.gson.annotations.SerializedName

data class Leader(
        @SerializedName("name") val name: String,
        @SerializedName("hours") val hours: Int?,
        @SerializedName("country") val country: String,
        @SerializedName("badgeUrl") val badgeUrl: String,
        @SerializedName("score") val score: Int
)