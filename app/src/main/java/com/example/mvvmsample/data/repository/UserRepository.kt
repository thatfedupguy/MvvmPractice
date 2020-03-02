package com.example.mvvmsample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmsample.data.db.AppDatabase
import com.example.mvvmsample.data.db.entites.User
import com.example.mvvmsample.data.network.MyApi
import com.example.mvvmsample.data.network.Responses.AuthResponse
import com.example.mvvmsample.data.network.SafeApiRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Appendable

class UserRepository(
    private val api : MyApi,
    private val db : AppDatabase

) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest{ api.userLogin(email, password)}
    }

    suspend fun userSignup(name : String, email: String, passwrod: String) : AuthResponse{
        return apiRequest { api.userSignup(name, email, passwrod) }
    }

    suspend fun saveUser(user : User) = db.getUserDao().upsert(user)

    fun  getUser() = db.getUserDao().getUser()


}