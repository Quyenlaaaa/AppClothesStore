package com.example.xacnhan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.xacnhan.Adapter.QuanAoAdapter;
import com.example.xacnhan.R;

import java.util.ArrayList;
import java.util.List;

public class Activity_huydonhang extends AppCompatActivity {
    ListView simpleList;
    String Lista[] = {"x1 Quần Jeen","x1 Áo Sơ Mi","x1 Áo khoác ngoài","x1 Áo mưa"};
    String List2[] ={ "50000đ","70000đ","999999đ","1 tỷ đô la"};
    int flag[] ={ R.drawable.ao, R.drawable.ao, R.drawable.ao, R.drawable.ao};

    private List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huydonhang);

        Button bt_back = (Button) findViewById(R.id.backve);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_huydonhang.this, MainActivity.class);
                startActivity(intent);
            }
        });

        simpleList	=	 (ListView)findViewById(R.id.lvquanao);
        items.add("x1 Quần Jeen");
        items.add("x1 Quần Jeen");
        items.add("x1 Quần Jeen");
        items.add("x1 Quần Jeen");
        QuanAoAdapter adapter	= 	new QuanAoAdapter( Activity_huydonhang.this, Lista,List2,flag);
        simpleList.setAdapter(adapter);
    }
}