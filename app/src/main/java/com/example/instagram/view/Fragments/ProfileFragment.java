package com.example.instagram.view.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.model.images;
import com.example.instagram.utils.ItemAdapterClick;
import com.example.instagram.view.Adapter.imageAdapter;
import com.example.instagram.view.EditActivity;
import com.example.instagram.view.imageActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment implements View.OnClickListener, ItemAdapterClick {

    public static CircleImageView profileImage;

    RecyclerView recyclerView;
    private List<images> images;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        CircleImageView addImage = (CircleImageView) root.findViewById(R.id.add_image);
        profileImage = (CircleImageView) root.findViewById(R.id.profile_image);
        Button edtButton = (Button) root.findViewById(R.id.pro_button);

        addImage.setOnClickListener(this);
        edtButton.setOnClickListener(this);
        profileImage.setOnClickListener(this);

        recyclerView = root.findViewById(R.id.image_recycleview);

        images = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            images.add(new images("https://picsum.photos/id/867/200/200"));
        }

        imageAdapter imageAdapter = new imageAdapter(images,
                getActivity().getApplicationContext(), this, "profile");

        GridLayoutManager gridLayoutManager = new
                GridLayoutManager(getActivity().getApplicationContext(),
                3, GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(imageAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_image:
                Intent intent = new Intent(getActivity(), EditActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"Add Image", Toast.LENGTH_SHORT).show();
                break;

            case R.id.pro_button:
                Toast.makeText(getActivity(),"Edit button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.profile_image:
                break;
        }
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(), imageActivity.class);
        intent.putExtra("IMAGE", images.get(position));
        getActivity().startActivity(intent);
    }
}
