package com.yourcompany.android.toreadlist.models

sealed class NetworkResponse<out T>(val data: T?) {
  data class Error(val throwable: Throwable): NetworkResponse<Nothing>(data = null)
  data class Success<out T>(val result: T?): NetworkResponse<T>(result)
  object Loading : NetworkResponse<Nothing>(data = null)
}
