package com.example.mvvmsample.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.Utils.ApiException
import com.example.mvvmsample.Utils.Coroutines
import com.example.mvvmsample.Utils.NoInternetException
import com.example.mvvmsample.data.repository.UserRepository

class AuthViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    var name : String ?= null
    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun getLoggedInUser() = userRepository.getUser()

    fun onLoginButtonClicked(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            //Failure
            authListener?.onFailure("Invalid Email or Password")
            return
        }
        Coroutines.main {
            try{
                val authResponse = userRepository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    userRepository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }catch (e : ApiException){
                authListener?.onFailure(e.message!!)
            }catch (e : NoInternetException){
                authListener?.onFailure(e.message!!)
            }
        }
    }
    fun onSignup(view: View){
        Intent(view.context, SignupActivity:: class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onLogin(view: View){
        Intent(view.context, LoginActivity:: class.java).also {
            view.context.startActivity(it)
        }
    }
    fun onSignupButtonClicked(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty() || name.isNullOrEmpty()){
            authListener?.onFailure("Invalid Input")
            return
        }
        Coroutines.main{
            try {
                val authResponse = userRepository.userSignup(name!!, email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    userRepository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }catch (e : ApiException){
                authListener?.onFailure(e.message!!)
            }catch (e : NoInternetException){
                authListener?.onFailure(e.message!!)
            }
        }
    }
}