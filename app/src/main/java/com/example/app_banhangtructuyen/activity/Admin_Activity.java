package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.ListItemUserAdapter;

public class Admin_Activity extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Quản lý tài khoản","Cài Đặt các quyền", "Xem lịch sử hoạt động", "Quản lý sản phẩm", "Đăng xuất"};
    int flags[] = {R.drawable.group,R.drawable.gear , R.drawable.headphones, R.drawable.warningoctagon, R.drawable.signout};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ShowItemInUser();
    }
    public void ShowItemInUser() {
        simpleList = (ListView) findViewById(R.id.list);
        ListItemUserAdapter adapter = new ListItemUserAdapter(this, List, flags);
        simpleList.setAdapter(adapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent myintent = new Intent(Admin_Activity.this, HosoActivity.class);
                        startActivity(myintent);
                        break;
                    case 1:
                        Intent myintent1 = new Intent(Admin_Activity.this, DonHangCuaToiActivity.class);
                        startActivity(myintent1);
                        break;
                    case 2:
                        Intent myintent2 = new Intent(Admin_Activity.this, CaiDatActivity.class);
                        startActivity(myintent2);
                        break;
                    case 3:
                        Intent myintent3 = new Intent(Admin_Activity.this, HoTroActivity.class);
                        startActivity(myintent3);
                        break;
                    case 4:
                        Intent myintent4 = new Intent(Admin_Activity.this, DieuKhoanActivity.class);
                        startActivity(myintent4);
                        break;
                    case 5:
                        OpenDia(Gravity.CENTER);
                        break;


                }


            }
        });
    }
    public void OpenDia (int gravity)
    {
        final Dialog dialog = new Dialog(Admin_Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_tbdangxuat);
        Window window =dialog.getWindow();
        if(window==null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams wda= window.getAttributes();
        wda.gravity= gravity;
        window.setAttributes(wda);
        if(Gravity.BOTTOM==gravity)
        {
            dialog.setCancelable(true);

        } else
            dialog.setCancelable(false);
        Button btno = dialog.findViewById(R.id.btno);
        Button btyes = dialog.findViewById(R.id.btyes);
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}