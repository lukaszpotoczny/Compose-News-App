package com.example.composenewsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenewsapp.domain.manager.LocalUserManager
import com.example.composenewsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(userManager: LocalUserManager) : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        userManager.readAppEntry().onEach { onBoardingShown ->
            startDestination =
                if (onBoardingShown) Route.NewsNavigation.route
                else Route.AppStartNavigation.route
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}