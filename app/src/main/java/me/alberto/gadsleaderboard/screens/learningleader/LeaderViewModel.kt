package me.alberto.gadsleaderboard.screens.learningleader

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.alberto.gadsleaderboard.app.data.model.Leader
import me.alberto.gadsleaderboard.app.exception.ErrorHandler
import javax.inject.Inject

class LeaderViewModel @Inject constructor(
    private val repository: LeaderRepository,
    private val errorHandle: ErrorHandler,
) : ViewModel() {
    private val _leaderList = MutableLiveData<List<Leader>>()
    val leaderList: LiveData<List<Leader>> = _leaderList

    private val _errorMessage = MutableLiveData<String>()

    //TODO handle error
    val errorMessage = _errorMessage

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getLeaderList(type: Int) {
        viewModelScope.launch {
            _loading.value = true
            _errorMessage.postValue(null)
            try {
                if (type == 1) {
                    _leaderList.value = repository.getLearnLeaders()
                } else {
                    _leaderList.value = repository.getSkillLeaders()
                }
                _loading.value = false
            } catch (error: Exception) {
                _loading.value = false
                _errorMessage.postValue(errorHandle.getErrorMessage(error))
            }
        }
    }

}