package com.example.instagram.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.instagram.R;
import com.example.instagram.model.images;

public class imageActivity extends AppCompatActivity {

    private images images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        images = (images) getIntent().getSerializableExtra("IMAGE");
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }
}
