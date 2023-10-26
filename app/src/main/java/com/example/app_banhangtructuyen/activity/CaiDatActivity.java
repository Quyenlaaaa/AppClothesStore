package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.app_banhangtructuyen.R;

public class CaiDatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat);

    }
    public void goBack(View view){

        super.finish();
    }

}
