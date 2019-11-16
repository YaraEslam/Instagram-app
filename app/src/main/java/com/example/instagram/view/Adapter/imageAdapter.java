package com.example.instagram.view.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.model.images;
import com.example.instagram.utils.ItemAdapterClick;

import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageHolder> {

    private List<images> image;
    private Context context;
    private ItemAdapterClick itemAdapterClick;
    private String layout;

    public imageAdapter(List<images> image, Context context, ItemAdapterClick itemAdapterClick, String layout) {
        this.image = image;
        this.context = context;
        this.itemAdapterClick = itemAdapterClick;
        this.layout = layout;
    }

    @NonNull
    @Override
    public imageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        switch (layout){
            case "profile":
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
                break;
            case "story_home":
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story_image, parent, false);
                break;
            case "post_home":
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
                break;
        }

        return new imageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull imageHolder holder, final int position) {
        holder.bind(image.get(position), context);
        holder.itemView.setOnClickListener(view -> itemAdapterClick.onClick(position));
    }

    @Override
    public int getItemCount() {
        return image.size();
    }
}
