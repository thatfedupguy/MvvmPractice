package com.example.mvvmsample.ui.profile

import androidx.lifecycle.ViewModel
import com.example.mvvmsample.data.repository.UserRepository

class ProfileViewModel(
    userRepository: UserRepository
) : ViewModel() {
    var user = userRepository.getUser()

}
