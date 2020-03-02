package com.example.mvvmsample.data.network.Responses

import com.example.mvvmsample.data.db.entites.Quote

data class QuotesResponse (
    var isSuccessgfful : Boolean,
    var quotes : List<Quote>
)
