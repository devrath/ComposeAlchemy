package com.yourcompany.android.toreadlist.models

data class Book(
  val title: String,
  val author: String,
  val coverId: Int
) {
  val coverUrl: String
    get() {
        return "https://covers.openlibrary.org/b/id/$coverId-L.jpg"
    }

  val hasCover: Boolean
    get() { return coverId != 0 }
}
