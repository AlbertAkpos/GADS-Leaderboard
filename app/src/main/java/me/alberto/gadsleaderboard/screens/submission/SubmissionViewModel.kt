package me.alberto.gadsleaderboard.screens.submission

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.alberto.gadsleaderboard.app.exception.ErrorHandler
import javax.inject.Inject

class SubmissionViewModel @Inject constructor(
    private val repository: SubmitRepository,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    val email = MutableLiveData<String>()
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val githubLink = MutableLiveData<String>()


    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private fun submitProject() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                repository.submitProject(
                    email.value!!,
                    firstName.value!!,
                    lastName.value!!,
                    githubLink.value!!
                )

                _loading.postValue(false)
                _success.postValue(true)
            } catch (exp: Exception) {
                _loading.postValue(false)
                _success.postValue(false)
                errorHandler.getErrorMessage(exp)
            }
        }
    }

    fun verify() {
        if (email.value.isNullOrEmpty() ||
            firstName.value.isNullOrEmpty() ||
            lastName.value.isNullOrEmpty() ||
            githubLink.value.isNullOrEmpty()
        ) {
            return
        }

        submitProject()
    }

}