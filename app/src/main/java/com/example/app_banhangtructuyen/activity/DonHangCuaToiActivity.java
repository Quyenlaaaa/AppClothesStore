package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.ListItemTTHoTroAdapter;

public class DonHangCuaToiActivity extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Đơn xác nhận", "Đã giao - Đánh giá"};
    int flags[] = {R.drawable.packer,R.drawable.packaging};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang_cua_toi);
        simpleList	=	 (ListView)findViewById(R.id.lvdsdon);
        ListItemTTHoTroAdapter adapter	= 	new ListItemTTHoTroAdapter(this, List, flags);
        simpleList.setAdapter(adapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: Intent myintent = new Intent(DonHangCuaToiActivity.this, ChiTietDonHangActivity.class);
                        startActivity(myintent);break;
                    case 1: Intent myintent1 = new Intent(DonHangCuaToiActivity.this, DanhGiaActivity.class);
                        startActivity(myintent1); break;
                }
            }
        });
    }
    public void goBack(View view){

        super.finish();
    }

}