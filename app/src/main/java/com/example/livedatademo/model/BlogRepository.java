package com.example.livedatademo.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.example.livedatademo.model.Blog;
import com.example.livedatademo.service.RestApiService;
import com.example.livedatademo.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogRepository {
    private ArrayList<Blog> movies = new ArrayList<>();
    private MutableLiveData<List<Blog>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public BlogRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Blog>> getMutableLiveData() {

        RestApiService apiService = RetrofitInstance.getApiService();

        Call<BlogWrapper> call = apiService.getPopularBlog();

        call.enqueue(new Callback<BlogWrapper>() {
            @Override
            public void onResponse(Call<BlogWrapper> call, Response<BlogWrapper> response) {
                BlogWrapper mBlogWrapper = response.body();
                if (mBlogWrapper != null && mBlogWrapper.getBlog() != null) {
                    movies = (ArrayList<Blog>) mBlogWrapper.getBlog();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<BlogWrapper> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
