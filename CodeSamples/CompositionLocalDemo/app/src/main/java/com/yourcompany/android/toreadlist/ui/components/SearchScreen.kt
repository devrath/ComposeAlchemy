package com.yourcompany.android.toreadlist.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.yourcompany.android.toreadlist.LocalPaddings
import com.yourcompany.android.toreadlist.models.Book
import com.yourcompany.android.toreadlist.models.SearchState
import com.yourcompany.android.toreadlist.models.SearchUiState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
  searchUiState: SearchUiState,
  onSearch: (String) -> Unit,
  onAddToList: (Book) -> Unit,
  onBackPressed: () -> Unit,
  modifier: Modifier = Modifier
) {
  var searchTerm by remember { mutableStateOf("") }
  val keyboardController = LocalSoftwareKeyboardController.current

  Column(modifier = modifier) {
    OutlinedTextField(
      value = searchTerm,
      onValueChange = { searchTerm = it },
      placeholder = { Text("Search a book") },
      keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Search
      ),
      keyboardActions = KeyboardActions(
        onSearch = {
          keyboardController?.hide()
          onSearch(searchTerm)
        },
        onDone = {
          keyboardController?.hide()
          onSearch(searchTerm)
        }
      ),
      singleLine = true,
      modifier = Modifier
        .fillMaxWidth()
        .padding(LocalPaddings.current.medium)
    )
    when (searchUiState.state) {
      SearchState.LOADING -> ProgressBar()
      SearchState.DONE -> SearchResults(searchUiState, onAddToList)
    }
    BackHandler { onBackPressed() }
  }
}

@Composable
fun SearchResults(
  searchUiState: SearchUiState,
  onAddToList: (Book) -> Unit
) {
  LazyColumn {
    items(searchUiState.searchResult) { book ->
      BookRow(book, showAddToList = true, onAddToList = onAddToList)
    }
  }
}
