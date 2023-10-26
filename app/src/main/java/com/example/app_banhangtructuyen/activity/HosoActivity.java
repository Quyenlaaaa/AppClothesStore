package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.HosoAdapter;

public class HosoActivity extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Số điện thoại", "Giới tính", "Email", "Địa chỉ", "Thay đổi mật khẩu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoso);
        simpleList	=	 (ListView)findViewById(R.id.hoso);
        HosoAdapter adapter	= 	new HosoAdapter(this, List,null);
        simpleList.setAdapter(adapter);
    }
    public void goBack(View view) {
        // Đóng hoạt động hiện tại và quay lại hoạt động trước đó
        finish();
    }
}