package me.alberto.gadsleaderboard.screens.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.alberto.gadsleaderboard.R
import me.alberto.gadsleaderboard.activity.HostActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Timer().schedule(2000) {
            startActivity(Intent(this@SplashActivity, HostActivity::class.java))
            finish()
        }

    }
}