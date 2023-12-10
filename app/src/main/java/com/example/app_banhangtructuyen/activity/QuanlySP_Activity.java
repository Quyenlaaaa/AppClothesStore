package com.example.app_banhangtructuyen.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.QuanlysanphamAdapter;
import com.example.app_banhangtructuyen.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuanlySP_Activity extends AppCompatActivity {
    QuanlysanphamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_sp);

       ShowlistSanPhamChiTiet();
        Button buttonthem = (Button) findViewById(R.id.buttonthem);
        buttonthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QuanlySP_Activity.this,Themmoisp_Activity.class);
                startActivity(it);
            }
        });
    }
    private void ShowlistSanPhamChiTiet() {
        ListView gridView = (ListView) findViewById(R.id.list);
        ArrayList arrayList = new ArrayList<>();
        adapter = new  QuanlysanphamAdapter (this,arrayList);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("Sanpham");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot snap: snapshot.getChildren())
                {
                    Product sp = snap.getValue(Product.class);
                    arrayList.add(sp);

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


      //  arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
       // arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
       // arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",4));

        gridView.setAdapter(adapter);
    }
}