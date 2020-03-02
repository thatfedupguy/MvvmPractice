package com.example.mvvmsample.ui.quotes

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.Utils.lazyDeferred
import com.example.mvvmsample.data.repository.QuotesRepository
import kotlinx.coroutines.withContext

class QuotesViewModel(
    private val quotesRepository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred{
        quotesRepository.getQuotes()
    }

}
