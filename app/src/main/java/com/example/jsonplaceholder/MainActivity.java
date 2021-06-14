package com.example.jsonplaceholder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.jsonplaceholder.adapters.PostAdapter;
import com.example.jsonplaceholder.api.ApiFactory;
import com.example.jsonplaceholder.api.ApiService;
import com.example.jsonplaceholder.databinding.ActivityMainBinding;
import com.example.jsonplaceholder.pojo.Post;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        postAdapter = new PostAdapter();
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerView.setAdapter(postAdapter);
        List<Post> posts = new ArrayList<>();
        postAdapter.setPostList(posts);
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        apiService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(new Consumer<List<Post>>() {
                               @Override
                               public void accept(List<Post> posts) {

                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) {

                               }
                           }
                );
    }
}