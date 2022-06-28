package com.tuckz.guilds.screens.adventure

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuckz.guilds.GuildApplication
import com.tuckz.guilds.data.adventure.Adventure
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class AdventureUiState(
    val lastMsg: String
)

class AdventureViewModel(application: Application?) : ViewModel() {
    // needs to come from database
    private var adventure = (application as GuildApplication).a

    private val _uistate = MutableStateFlow(AdventureUiState(lastMsg = "This is a message"))
    val uiState: StateFlow<AdventureUiState> = _uistate.asStateFlow()
    init {
        viewModelScope.launch {
            var updateString = "No adventure"
            if (adventure != null) {
                updateString = adventure.uid.toString()
            }
            // Coroutine that will be canceled when the ViewModel is cleared.
            _uistate.update {
                it.copy(lastMsg = updateString)
            }
        }
    }
}
