/*
 * Copyright (c) 2022 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.yourcompany.android.toreadlist.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.yourcompany.android.toreadlist.LocalPaddings
import com.yourcompany.android.toreadlist.R
import com.yourcompany.android.toreadlist.models.Book
import com.yourcompany.android.toreadlist.ui.theme.MyReadingTheme

@Composable
fun BookRow(
  book: Book,
  modifier: Modifier = Modifier,
  showAddToList: Boolean = false,
  onAddToList: (Book) -> Unit = { }
) {
  val context = LocalContext.current
  Card(
    modifier = modifier
      .fillMaxWidth()
      .padding(all = LocalPaddings.current.small),
    elevation = 12.dp,
    shape = RoundedCornerShape(size = 11.dp)
  ) {
    Row(
      modifier = Modifier
        .padding(LocalPaddings.current.medium)
    ) {
      AsyncImage(
        modifier = Modifier
          .width(120.dp)
          .padding(end = LocalPaddings.current.small),
        model = ImageRequest
          .Builder(context)
          .data(book.coverUrl)
          .error(context.getDrawable(R.drawable.error_cover))
          .build(),
        contentScale = ContentScale.Crop,
        contentDescription = book.title
      )
      Column {
        Text(text = book.title, style = MyReadingTheme.typography.H5)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = book.author, style = MyReadingTheme.typography.subtitle)
        Spacer(modifier = Modifier.height(4.dp))

        if (showAddToList) {
          Button(
            onClick = {
              onAddToList(book)
              Toast.makeText(context, "Added to list", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(text = "Add to List")
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun PreviewBookRow() {
  BookRow(
    Book(author = "Author", title = "title", coverId = 1234)
  )
}