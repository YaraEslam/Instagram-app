package com.example.instagram.view.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.model.images;
import com.squareup.picasso.Picasso;

class imageHolder extends RecyclerView.ViewHolder {

    private ImageView profile_imageView ;
    private TextView profileName_tv;
    private ImageView home_image_post;


    imageHolder(@NonNull View itemView) {
        super(itemView);
        profile_imageView = itemView.findViewById(R.id.img_item);
        try {
            profileName_tv = itemView.findViewById(R.id.home_username);
            home_image_post = itemView.findViewById(R.id.home_image);
        }catch (Exception ignored){ }
    }

    void bind(@NonNull images img, Context context) {
        Picasso.with(context)
                .load(img.getProfileImage())
                .placeholder(R.drawable.ic_add_black_24dp)
                .into(profile_imageView);
        try {
            profileName_tv.setText(img.getProfileName());

            Picasso.with(context)
                    .load(img.getHome_image())
                    .placeholder(R.drawable.profile)
                    .into(home_image_post);
        }catch (Exception ignored){ }
    }
}
