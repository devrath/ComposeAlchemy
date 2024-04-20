package com.yourcompany.android.toreadlist.network.models

import com.google.gson.annotations.SerializedName

data class SearchDto(
  @SerializedName("docs")
  val books: List<BookDto>
)
