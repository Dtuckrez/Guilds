package com.tuckz.guilds.screens.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.math.log


data class LoginUiState(
    val lastMsg: String
)

class LoginViewModel(private val application: Application?) : ViewModel() {
    // needs to come from database
    private val _uistate = MutableStateFlow(LoginUiState(lastMsg = "This is a message"))
    val uiState: StateFlow<LoginUiState> = _uistate.asStateFlow()

    init {
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }

    fun performLogin() {
        val queue = Volley.newRequestQueue(application)
        val url = "http://10.0.2.2:8080/signin"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                val t = "Response is: ${response.substring(0, 500)}"
                Log.d("LoginViewModel", t)
            },
            Response.ErrorListener {
                Log.d("LoginViewModel", it.message!!)
            })

        queue.add(stringRequest)

    }

}
