package com.example.jsonplaceholder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jsonplaceholder.adapters.PostAdapter;
import com.example.jsonplaceholder.databinding.ActivityMainBinding;
import com.example.jsonplaceholder.pojo.Post;

import java.util.ArrayList;
import java.util.List;

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
        posts.add(new Post().setTitle("hello").setId(1).setBody("sasasassasasasasasasaasas").setUserId(111));
        posts.add(new Post().setTitle("hellodsds").setId(1).setBody("sasasadsdsdsdsdsssasasasasasasaasas").setUserId(111));
        posts.add(new Post().setTitle("hi").setId(1).setBody("sasasadsdsdsdssdsdsdssdsssasasasasasasaasas").setUserId(111));
        postAdapter.setPostList(posts);
    }
}