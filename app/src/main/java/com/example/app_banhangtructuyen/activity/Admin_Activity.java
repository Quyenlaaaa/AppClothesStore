package com.example.app_banhangtructuyen.activity;

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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.ListItemUserAdapter;

public class Admin_Activity extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Quản lý tài khoản","Cài Đặt các quyền", "Xem lịch sử hoạt động", "Quản lý sản phẩm", "Trở về"};
    int flags[] = {R.drawable.group, R.drawable.gear , R.drawable.headphones, R.drawable.warningoctagon, R.drawable.signout};
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
                        Toast.makeText(Admin_Activity.this, "Chức năng đăng phát triển", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(Admin_Activity.this, "Chức năng đăng phát triển", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(Admin_Activity.this, "Chức năng đăng phát triển", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Intent myintent3 = new Intent(Admin_Activity.this, QuanlySP_Activity.class);
                        startActivity(myintent3);
                        break;
                    case 4:
                        finish();
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