package com.example.app_banhangtructuyen.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.ListItemTTHoTroAdapter;
import com.example.app_banhangtructuyen.fragment.FragmentHome;
import com.example.app_banhangtructuyen.fragment.FragmentUser;
import com.example.app_banhangtructuyen.model.Product;
import com.example.app_banhangtructuyen.model.UserSingleton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DonHangCuaToiActivity extends AppCompatActivity {
    ImageView back;
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
                    case 0: CheckHoaDon();
                       break;
                }
            }
        });
        back = findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonHangCuaToiActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CheckHoaDon() {
        UserSingleton userSingleton = UserSingleton.getInstance();
        String email = userSingleton.getUsername();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference hoadon = database.getReference("Hoadon");
        hoadon.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean check = false;
                for (DataSnapshot snap:snapshot.getChildren()) {
                    String emaila = snap.child("user").getValue(String.class);
                    if (email.equals(emaila) == true) {
                        check = true;
                        Intent myintent = new Intent(DonHangCuaToiActivity.this, ChiTietDonHangActivity.class);
                        startActivity(myintent);
                    }
                }
                if (check==false)
                    Toast.makeText(DonHangCuaToiActivity.this, "Chưa có đơn hàng nào đang đặt", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}