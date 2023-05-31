package com.example.newschannelproject.viewmodel

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newschannelproject.domain.NewsApi
import com.example.newschannelproject.newsData.Article
import com.example.newschannelproject.newsData.NewsDataClasses
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Stable
data class NewsUIState(val articles :List<Article>)

class NewsViewModel : ViewModel() {
    //MutableStateFlow ve StateFlow nedir?
    private val _newsUIState = MutableStateFlow(NewsUIState(emptyList()))
    val newsUIState : StateFlow<NewsUIState> = _newsUIState

    //init nedir ? ne işe yarar?
    init {
        //viewModelScope nedir?
        viewModelScope.launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val api = retrofit.create(NewsApi::class.java)

            api.getNewsDataClasses().enqueue(object : Callback<NewsDataClasses> {
                override fun onResponse(
                    call: Call<NewsDataClasses>,
                    response: Response<NewsDataClasses>

                ) {
                    _newsUIState.update {
                        it.copy(
                            articles = response.body()?.articles?: emptyList()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsDataClasses>, t: Throwable) {
                    _newsUIState.update {
                        it.copy(
                            articles = emptyList()
                        )
                    }
                }
            })
        }
    }
}