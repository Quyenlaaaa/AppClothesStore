package com.example.app_banhangtructuyen.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.HosoAdapter;
import com.example.app_banhangtructuyen.model.UserSingleton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HosoActivity extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Số điện thoại", "Giới tính", "Email", "Địa chỉ", "Thay đổi mật khẩu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoso);
        ImageButton btcn = (ImageButton) findViewById(R.id.capnhat);
        btcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(HosoActivity.this,CapnhatActivity.class);
                startActivity(it);
            }
        });
        simpleList	=	 (ListView)findViewById(R.id.hoso);
        TextView tendn = (TextView)findViewById(R.id.tendangnhap);

        UserSingleton userSingleton = UserSingleton.getInstance();
        String email = userSingleton.getUsername();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("Khachhang");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap:snapshot.getChildren())
                {
                    String emaila = snap.child("phone_email").getValue(String.class);

                    if( email.equals(emaila)==true)
                    {
                        String hoten = snap.child("hoTen").getValue(String.class);
                        String diaChi = snap.child("diaChi").getValue(String.class);
                        String emailb = snap.child("phone_email").getValue(String.class);
                        String pass = snap.child("password").getValue(String.class);
                        String gioitinh=snap.child("gioitinh").getValue(String.class);;
//
                        String sodienthoai =snap.child("sodt").getValue(String.class);;

                        String ListValue[]={sodienthoai,gioitinh,emailb,diaChi,pass};
                        HosoAdapter adapter	= 	new HosoAdapter(HosoActivity.this, List,ListValue,null);
                        simpleList.setAdapter(adapter);
                        tendn.setText(hoten);


                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void goBack(View view) {
        // Đóng hoạt động hiện tại và quay lại hoạt động trước đó
        finish();
    }
}