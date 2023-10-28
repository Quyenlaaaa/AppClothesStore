package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.CaidatAdapter;

public class CaiDatActivity extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Thông báo", "Cập nhật đơn hàng", "Khuyến mãi từ các cửa hàng", "Nhắc nhở", "Chuông thông báo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat);
        simpleList	=	 (ListView)findViewById(R.id.lvcaidat);
        CaidatAdapter adapter	= 	new CaidatAdapter(this, List,null);
        simpleList.setAdapter(adapter);


    }

    public void goBack(View view){

        super.finish();
    }

}
