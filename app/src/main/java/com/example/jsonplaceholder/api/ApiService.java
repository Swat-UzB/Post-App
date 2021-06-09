package com.example.jsonplaceholder.api;

import com.example.jsonplaceholder.pojo.Post;


import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {
    @GET("posts")
    Observable<List<Post>> getPosts();
}
