package com.example.mvvmsample.ui.auth

import com.example.mvvmsample.data.db.entites.User

interface AuthListener {

    fun onStarted()
    fun onFailure(message : String)
    fun onSuccess(user : User)
}