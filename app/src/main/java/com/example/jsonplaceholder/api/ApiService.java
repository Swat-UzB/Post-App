package com.example.jsonplaceholder.api;

import com.example.jsonplaceholder.pojo.Post;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiService {
    @GET("posts")
    Observable<List<Post>> getPosts();
}
