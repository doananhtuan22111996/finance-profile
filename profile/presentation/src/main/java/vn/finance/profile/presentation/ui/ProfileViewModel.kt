package vn.finance.profile.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import vn.core.domain.ResultModel
import vn.finance.profile.business.domain.model.PersonModel
import vn.finance.profile.business.domain.usecase.GetProfileUseCase
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val getProfileUseCase: GetProfileUseCase) :
    ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _appException = MutableStateFlow<ResultModel.AppException?>(null)
    val appException = _appException.asStateFlow()

    private val _person = MutableStateFlow<PersonModel?>(null)
    val person = _person.asStateFlow()

    init {
        getProfile()
    }

    fun onDismissAppException() {
        viewModelScope.launch {
            _appException.value = null
        }
    }

    private fun getProfile() {
        viewModelScope.launch {
            getProfileUseCase.execute().collect {
                when (it) {
                    is ResultModel.Loading -> _isLoading.value = true
                    is ResultModel.Success -> _person.value = it.data
                    is ResultModel.AppException -> _appException.value = it
                    else -> _isLoading.value = false
                }
            }
        }
    }
}