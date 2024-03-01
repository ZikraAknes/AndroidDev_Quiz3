package com.example.quiz3androiddevelopment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView albumId, id, title, url, thumbUrl;
    ImageView imageView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        albumId = itemView.findViewById(R.id.albumId);
        title = itemView.findViewById(R.id.title);
        imageView = itemView.findViewById(R.id.imageView);
    }

}
