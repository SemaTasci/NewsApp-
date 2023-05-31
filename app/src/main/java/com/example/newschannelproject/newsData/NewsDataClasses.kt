package com.example.newschannelproject.newsData

data class NewsDataClasses(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)