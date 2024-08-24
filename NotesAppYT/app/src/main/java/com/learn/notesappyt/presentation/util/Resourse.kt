package com.learn.notesappyt.presentation.util

sealed class Resourse<T>(
    message : String ? = null,
    data : T? = null

) {
    class Loding<T> : Resourse<T>()
    class Success<T>(val data: T?) : Resourse<T>(data = data)
    class Error<T>(val message: String?) : Resourse<T>(message = message)

}