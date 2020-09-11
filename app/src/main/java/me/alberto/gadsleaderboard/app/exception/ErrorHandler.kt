package me.alberto.gadsleaderboard.app.exception

import android.content.Context
import androidx.annotation.StringRes
import me.alberto.gadsleaderboard.R
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class ErrorHandler @Inject constructor(private val context: Context) {

    fun getErrorMessage(e: Throwable): String {
        if (e is HttpException) {
            return e.message()
        }

        if (e is ConnectException) {
            return getString(R.string.connect_exception)
        }
        if (e is UnknownHostException) {
            return getString(R.string.unknown_host_exception)
        }
        if (e is SocketTimeoutException) {
            return getString(R.string.timed_out_exception)
        }

        if (e is AppException) {
            val message = e.message
            return if (message.isNullOrEmpty()) getString(R.string.unknown_exception) else message
        }

        return getString(R.string.unknown_exception)
    }

    private fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }
}