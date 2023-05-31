package com.example.newschannelproject.domain;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApiService {
    @GET("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=b7ac73c1c694404784422862e0956f7c")
    Call<RetrofitBuilder> newresponse();
}
