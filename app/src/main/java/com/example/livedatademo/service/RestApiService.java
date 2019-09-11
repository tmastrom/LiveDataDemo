package com.example.livedatademo.service;

import com.example.livedatademo.model.BlogWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

// retrofit with LiveData for interacting WebService
public interface RestApiService {
    @GET("feed.json")
    Call<BlogWrapper> getPopularBlog();
}
