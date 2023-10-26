package com.example.app_banhangtructuyen.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.fragment.FragmentCart;
import com.example.app_banhangtructuyen.fragment.FragmentHome;
import com.example.app_banhangtructuyen.fragment.FragmentThongBao;
import com.example.app_banhangtructuyen.fragment.FragmentUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomnav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        loadFragment(new FragmentHome());
        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if(item.getItemId() == R.id.iconhome)
                {
                    fragment = new FragmentHome();
                    loadFragment(fragment);
                }
                if(item.getItemId() == R.id.iconcart)
                {
                    fragment = new FragmentCart();
                    loadFragment(fragment);
                }
                if(item.getItemId() == R.id.iconuser)
                {
                    fragment = new FragmentUser();
                    loadFragment(fragment);
                }
                return true;
            }


        });

    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}