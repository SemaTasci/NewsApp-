package com.example.newschannelproject.domain;

public class ApiUtils {
    public static final String BASE_URL = "https://newsapi.org/v2/";

    public static NewsApiService getnewsApiService() {
        return RetrofitBuilder.getClient(BASE_URL).create(NewsApiService.class);

    }
}
