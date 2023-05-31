package com.example.newschannelproject.domain

import com.example.newschannelproject.newsData.NewsDataClasses
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("top-headlines?country=us&category=business&apiKey=b7ac73c1c694404784422862e0956f7c")
    fun getNewsDataClasses(): Call<NewsDataClasses>
}

    //suspend fun getArticles():List<Article>
    //suspend fun getSource():List<Source>
    /*companion object{
        var apiService:NewsApiService?=null
        fun getInstance():NewsApiService{
            if(apiService==null){
                apiService=Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(NewsApiService::class.java)
            }
            return apiService!!
        }
    }
}*/