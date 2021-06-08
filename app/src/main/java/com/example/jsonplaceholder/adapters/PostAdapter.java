package com.example.jsonplaceholder.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.databinding.PostItemBinding;
import com.example.jsonplaceholder.pojo.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList;

    public void setPostList(List<Post> postList) {
        this.postList.clear();
        this.postList.addAll(postList);
        notifyDataSetChanged();
    }

    public PostAdapter() {
        postList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.postItemBinding.textViewPostId.setText(String.valueOf(post.getId()));
        holder.postItemBinding.textViewBody.setText(post.getBody());
        holder.postItemBinding.textViewTitle.setText(post.getTitle());
        holder.postItemBinding.textViewUserId.setText(String.valueOf(post.getUserId()));
    }

    @Override
    public int getItemCount() {
        return postList == null ? 0 :
                postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private PostItemBinding postItemBinding;

        public PostViewHolder(PostItemBinding postItemBinding) {
            super(postItemBinding.getRoot());
            this.postItemBinding = postItemBinding;
        }
    }
}
