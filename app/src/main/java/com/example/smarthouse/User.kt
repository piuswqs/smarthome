package com.example.smarthouse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: String,
    var email: String,
    val name: String,
    val password: String,
    val address: String,
)
