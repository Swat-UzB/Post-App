package com.example.jsonplaceholder.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.pojo.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList;

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  PostAdapter.PostViewHolder holder, int position) {
    Post post = postList.get(position);
    holder.postId.setText(post.getId());
    holder.userId.setText(post.getUserId());
    holder.body.setText(post.getBody());
    holder.title.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView userId;
        private TextView postId;
        private TextView title;
        private TextView body;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.textViewUserId);
            postId = itemView.findViewById(R.id.textViewPostId);
            title = itemView.findViewById(R.id.textViewTitle);
            body = itemView.findViewById(R.id.textViewBody);
        }
    }


}
