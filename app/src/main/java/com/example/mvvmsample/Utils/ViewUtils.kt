package com.example.mvvmsample.Utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ProgressBar.hide(){
    visibility = ProgressBar.GONE
}

fun ProgressBar.show(){
    visibility = ProgressBar.VISIBLE
}
fun View.snackbar(message: String) {
    Snackbar
        .make(this, message, Snackbar.LENGTH_INDEFINITE)
        .also { snackbar ->
            snackbar.setAction("OK") {
                snackbar.dismiss()
            }
        }.show()

}