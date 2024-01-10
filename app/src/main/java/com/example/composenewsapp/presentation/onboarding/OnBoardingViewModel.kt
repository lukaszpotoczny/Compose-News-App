package com.example.composenewsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenewsapp.domain.manager.LocalUserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userManager: LocalUserManager
) : ViewModel() {

    fun markAppEntry() {
        viewModelScope.launch {
            userManager.saveAppEntry()
        }
    }
}