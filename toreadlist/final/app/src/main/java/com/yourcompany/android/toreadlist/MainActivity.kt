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
package com.yourcompany.android.toreadlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yourcompany.android.toreadlist.models.SearchUiState
import com.yourcompany.android.toreadlist.ui.components.BookListScreen
import com.yourcompany.android.toreadlist.ui.components.SearchScreen
import com.yourcompany.android.toreadlist.ui.theme.ToReadListTheme
import com.yourcompany.android.toreadlist.viewmodels.BookListViewModel
import com.yourcompany.android.toreadlist.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  private val searchViewModel: SearchViewModel by viewModels()
  private val bookListViewModel: BookListViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
        ToReadListTheme {
          val navController = LocalNavigationProvider.current
          NavHost(navController = navController, startDestination = "booklist") {
            composable("booklist") {
              val books by bookListViewModel.bookList.collectAsState(emptyList())
              bookListViewModel.getBookList()
              BookListScreen(books)
            }
            composable("search") {
              val searchUiState by searchViewModel.searchUiState.collectAsState(SearchUiState())
              SearchScreen(
                searchUiState = searchUiState,
                onSearch = { searchViewModel.search(it) },
                onAddToList = { searchViewModel.addToList(it) },
                onBackPressed = {
                  searchViewModel.clearResults()
                  navController.popBackStack()
                }
              )
            }
          }
        }
      }
    }
  }
}
