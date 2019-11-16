package com.example.instagram.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.instagram.R;
import com.example.instagram.view.Fragments.ProfileFragment;

public class EditActivity extends AppCompatActivity {

    ImageView btn_camera, btn_gallery;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK){
            Uri uri = data.getData();
            ProfileFragment.profileImage.setImageURI(uri);
        }

        if (requestCode == 102 && resultCode == RESULT_OK){
            ProfileFragment.profileImage.setImageBitmap((Bitmap)data.getExtras().get("data"));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //get the screen size to set the width & height of pop-up
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.4));

        btn_camera = (ImageView) findViewById(R.id.camera);
        btn_gallery = (ImageView) findViewById(R.id.gallery);

        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                intent.putExtra("crop","true");
                startActivityForResult(intent, 100);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 102);
            }
        });

    }
}
