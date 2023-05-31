package com.example.newschannelproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.newschannelproject.presentation.NewsItem
import com.example.newschannelproject.ui.theme.NewsChannelProjectTheme
import com.example.newschannelproject.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsChannelProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticleList()
                }
            }
        }
    }


}

@Composable
fun ArticleList() {
    val newsViewModel = NewsViewModel()
    val state = newsViewModel.newsUIState.collectAsState()
    LazyColumn{
        itemsIndexed(items= state.value.articles){index, item ->
          NewsItem(article = item)
        }
    }

}

