package com.example.massproject_test.ui.screens.main.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.massproject_test.common.collectAsResult
import com.example.massproject_test.domain.model.Character
import com.example.massproject_test.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            homeRepository.getAllCharacters().collectAsResult(
                onLoading = {
                    Log.d("MyTag", "Loading")
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                },
                onSuccess = { requestResult ->
                    requestResult.data?.let { character ->
                        Log.d("MyTag", "${character}")
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                character = character
                            )
                        }
                    }
                },
                onError = { _, _ ->
                    Log.d("MyTag", "Error")
                    _uiState.update {
                        it.copy(
                            isLoading = false
                        )
                    }
                }
            )
        }
    }
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val character: Character? = null,
)