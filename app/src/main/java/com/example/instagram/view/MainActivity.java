package com.example.instagram.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.instagram.R;
import com.example.instagram.view.Fragments.AddFragment;
import com.example.instagram.view.Fragments.HomeFragment;
import com.example.instagram.view.Fragments.ProfileFragment;
import com.example.instagram.view.Fragments.SearchFragment;
import com.example.instagram.view.Fragments.TrendsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        openFragment( new HomeFragment());
    }

    private void initUI() {
        BottomNavigationView nav_View = findViewById(R.id.nav_view);
        nav_View.setOnNavigationItemSelectedListener(this);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fraq, fragment);
        transaction.commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length <= 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                openFragment(new HomeFragment());
                return true;
            case R.id.nav_search:
                openFragment(new SearchFragment());
                return true;
            case R.id.nav_add:
                openFragment(new AddFragment());
                return true;
            case R.id.nav_trends:
                openFragment(new TrendsFragment());
                return true;
            case R.id.nav_profile:
                openFragment(new ProfileFragment());
                return true;
        }
        return false;
    }
}
