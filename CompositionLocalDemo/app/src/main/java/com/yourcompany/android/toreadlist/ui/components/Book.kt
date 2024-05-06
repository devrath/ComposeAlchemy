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