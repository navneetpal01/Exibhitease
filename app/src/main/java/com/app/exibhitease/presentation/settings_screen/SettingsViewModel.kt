package com.app.exibhitease.presentation.settings_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.exibhitease.core.SettingsConstants
import com.app.exibhitease.data.settings.SettingsDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsDataStore: SettingsDataStore
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        SettingsState()
    )

    var setKeepOnScreenCondition: Boolean = true

    init {
        viewModelScope.launch {
            val firstLaunch = async { settingsDataStore.getBoolean(SettingsConstants.FIRST_LAUNCH) ?: true }
            val darkMode = async { settingsDataStore.getBoolean(SettingsConstants.DARK_MODE_TYPE) }
            val amoledTheme = async { settingsDataStore.getBoolean(SettingsConstants.AMOLED_THEME_TYPE) ?: false }
            val dynamicTheming = async { settingsDataStore.getBoolean(SettingsConstants.DYNAMIC_THEME_TYPE) ?: false }

            _state.update {
                it.copy(
                    firstLaunch = firstLaunch.await(),
                    darkMode = darkMode.await(),
                    amoledTheme = amoledTheme.await(),
                    dynamicTheming = dynamicTheming.await()
                )
            }
            setKeepOnScreenCondition = false
        }
    }

    fun onEvent(event : SettingsEvent){
        when(event){
            SettingsEvent.SetFirstLaunch -> {

            }
            is SettingsEvent.SetAmoledTheme -> {

            }
            is SettingsEvent.SetDarkMode -> {

            }
            is SettingsEvent.SetDynamicTheming -> {

            }
        }
    }

}