package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.app_banhangtructuyen.R;

public class LiDoHuyDonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_do_huy_don);
        CheckBox checkbox1 = findViewById(R.id.checkbox1);
        CheckBox checkbox2 = findViewById(R.id.checkbox2);
        CheckBox checkbox3 = findViewById(R.id.checkbox3);
        CheckBox checkbox4 = findViewById(R.id.checkbox4);
        CheckBox checkbox5 = findViewById(R.id.checkbox5);
        CheckBox checkbox6 = findViewById(R.id.checkbox6);
        CheckBox checkbox7 = findViewById(R.id.checkbox7);

        Button xacNhanButton = findViewById(R.id.btxoa);

        xacNhanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkbox1.isChecked()) {
                }
                if (checkbox2.isChecked()) {
                }
                if (checkbox3.isChecked()) {
                }
                if (checkbox4.isChecked()) {
                }
                if (checkbox5.isChecked()) {
                }
                if (checkbox6.isChecked()) {
                }
                if (checkbox7.isChecked()) {
                }
                finish();
            }
        });
    }

    public void goBack(View view) {
        finish();
    }
}