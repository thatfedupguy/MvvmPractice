package com.example.mvvmsample.data.network.Responses

import com.example.mvvmsample.data.db.entites.User

data class AuthResponse(
    var isSuccessful : Boolean?,
    var message : String?,
    var user : User?
)