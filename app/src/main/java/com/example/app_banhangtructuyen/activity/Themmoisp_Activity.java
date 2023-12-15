package com.example.app_banhangtructuyen.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Themmoisp_Activity extends AppCompatActivity {
    Product product;
    String keya=null;
    ArrayList<String> listspin;
    ArrayAdapter<String> adapter;
    Button btthem ;
    String value="Quần Jean";
    String a=null;
    Integer ma=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themmoisp);
        btthem=(Button)findViewById(R.id.them);
        EditText id=findViewById(R.id.idsp);
        EditText ten=findViewById(R.id.tensp);
        EditText gia=findViewById(R.id.giasp);
        EditText mota=findViewById(R.id.mota);
        EditText hinhanh=findViewById(R.id.hinhanh);
        EditText sl=findViewById(R.id.soluong);
        Spinner madm=findViewById(R.id.madanhmuc);
        listspin = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listspin);
        SpinerData();
        madm.setAdapter(adapter);
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                madm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Object selectedItem = parent.getSelectedItem();
                        value = selectedItem.toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                DatabaseReference reference =firebaseDatabase.getReference("Danhmuc");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot snap:snapshot.getChildren())
                        {
                            String mas =snap.child("TenDM").getValue(String.class);
                            if(value.equals(mas)==true)
                            {
                                DatabaseReference myRef = firebaseDatabase.getReference("Sanpham");
                                Integer  madms=snap.child("MaDM").getValue(Integer.class);

                                        product = new Product(Integer.parseInt(id.getText().toString()),ten.getText().toString(),Integer.parseInt(gia.getText().toString()),hinhanh.getText().toString(),madms,mota.getText().toString(),Integer.parseInt(sl.getText().toString()));
                                       myRef.push().setValue(product);

                                        Toast.makeText(Themmoisp_Activity.this, "Thêm mới thành công" , Toast.LENGTH_SHORT).show();



                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//                Toast.makeText(Themmoisp_Activity.this,String.valueOf(returnma(value)), Toast.LENGTH_SHORT).show();




            }

        });
    }
    private  void  SpinerData (){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("Danhmuc");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listspin.clear();
                for (DataSnapshot snap:snapshot.getChildren())
                {
                    listspin.add(snap.child("TenDM").getValue(String.class));
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void returnma(String name)

    {

    }

}