package com.example.livedatademo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.livedatademo.model.Blog;
import com.example.livedatademo.model.BlogRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private BlogRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new BlogRepository(application);
    }

    public LiveData<List<Blog>> getAllBlog() {
        return movieRepository.getMutableLiveData();
    }

}
