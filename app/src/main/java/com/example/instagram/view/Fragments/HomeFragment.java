package com.example.instagram.view.Fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.model.images;
import com.example.instagram.utils.ItemAdapterClick;
import com.example.instagram.view.Adapter.imageAdapter;
import com.example.instagram.view.imageActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements ItemAdapterClick {

    RecyclerView recyclerView_story, recyclerView_post;
    private List<images> images_story, images_post;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView_story = view.findViewById(R.id.story_image_recycleview);
        recyclerView_post = view.findViewById(R.id.home_image_recycleview);

        images_story = new ArrayList<>();
        images_post = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            images_story.add(new images("https://picsum.photos/id/867/200/200"));
            images_post.add(new images("https://picsum.photos/id/867/200/200",
                    "Username","https://picsum.photos/id/867/200/200"));
        }
        images_story.add(new images("R.drawable.ic_add_black_24dp"));

        imageAdapter imageAdapter_story = new imageAdapter(images_story,
                getActivity().getApplicationContext(), this, "story_home");

        imageAdapter imageAdapter_post = new imageAdapter(images_post,
                getActivity().getApplicationContext(), this, "post_home");

        LinearLayoutManager linearLayoutManager_story = new
                LinearLayoutManager(getActivity().getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, true);

        LinearLayoutManager linearLayoutManager_post = new
                LinearLayoutManager(getActivity().getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);

        recyclerView_story.setLayoutManager(linearLayoutManager_story);
        recyclerView_post.setLayoutManager(linearLayoutManager_post);

        recyclerView_story.setAdapter(imageAdapter_story);
        recyclerView_post.setAdapter(imageAdapter_post);


        return view;
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(), imageActivity.class);
        intent.putExtra("IMAGE", images_story.get(position));
        getActivity().startActivity(intent);
    }
}
