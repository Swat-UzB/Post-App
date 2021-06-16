package com.example.jsonplaceholder;

import androidx.appcompat.app.AppCompatActivity;
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

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {

                               @Override
                               public void onSubscribe( Disposable d) {

                               }

                               @Override
                               public void onNext( List<Post> posts) {

                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onComplete() {

                               }
                           }
                );
    }
}