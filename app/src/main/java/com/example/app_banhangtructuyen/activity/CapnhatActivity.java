package com.example.app_banhangtructuyen.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.HosoAdapter;
import com.example.app_banhangtructuyen.model.UserSingleton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CapnhatActivity extends AppCompatActivity {
    boolean isProcessing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capnhat);
        EditText gioitinh=(EditText) findViewById(R.id.gioitinh);
        EditText diachi=(EditText) findViewById(R.id.diachi);
        EditText sdt=(EditText) findViewById(R.id.sdt);
        EditText matkhau=(EditText) findViewById(R.id.matkhau);
        EditText dapa=(EditText) findViewById(R.id.dapa);
        AppCompatButton btcap =(AppCompatButton)findViewById(R.id.btcn);
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
                        String hotenb = snap.child("hoTen").getValue(String.class);
                        String diaChib = snap.child("diaChi").getValue(String.class);
                        String emailb = snap.child("phone_email").getValue(String.class);
                        String passb = snap.child("password").getValue(String.class);
                        String gioitinhb=snap.child("gioitinh").getValue(String.class);;
//
                        String sodienthoaib =snap.child("sodt").getValue(String.class);;
                        gioitinh.setText(gioitinhb);
                        diachi.setText(diaChib);
                        sdt.setText(sodienthoaib);
                        matkhau.setText(passb);



                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btcap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(!isProcessing) {
                            isProcessing = true;
                            for (DataSnapshot snap:snapshot.getChildren())
                            {
                                String emaila = snap.child("phone_email").getValue(String.class);

                                if( email.equals(emaila)==true)
                                {
                                    myRef.child(snap.getKey().toString()).child("diaChi").setValue(diachi.getText().toString().trim());
                                    myRef.child(snap.getKey().toString()).child("gioitinh").setValue(gioitinh.getText().toString().trim());
                                    myRef.child(snap.getKey().toString()).child("sodt").setValue(sdt.getText().toString().trim());
                                    myRef.child(snap.getKey().toString()).child("password").setValue(matkhau.getText().toString().trim());
                                    break;


                                }

                            }
                            Toast.makeText(CapnhatActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            isProcessing=false;
                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
    public void goBack(View view) {
        // Đóng hoạt động hiện tại và quay lại hoạt động trước đó
        finish();
    }
}