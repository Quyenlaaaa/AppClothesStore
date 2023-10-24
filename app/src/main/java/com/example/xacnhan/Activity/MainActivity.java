package com.example.xacnhan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.xacnhan.Adapter.QuanAoAdapter;
import com.example.xacnhan.Adapter.RCAdapter;
import com.example.xacnhan.Adapter.ThoigianAdapter;
import com.example.xacnhan.Adapter.XacnhanAdapter;
import com.example.xacnhan.Domain.QuanAo;
import com.example.xacnhan.Domain.Thoigian;
import com.example.xacnhan.Domain.Xacnhan;
import com.example.xacnhan.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Context context;
    ListView simpleList;
    RecyclerView simpleList2;
    private RecyclerView rcvData;
    private RecyclerView rcvData1;
    private XacnhanAdapter xacnhanAdapter;
    private ThoigianAdapter thoigianAdapter;
    String Lista[] = {"x1 Quần Jeen","x1 Áo Sơ Mi","x1 Áo khoác ngoài","x1 Áo mưa"};

    int flag[] ={ R.drawable.ao, R.drawable.ao, R.drawable.ao, R.drawable.ao};
    String List2[] ={ "50.000đ","70.000đ","150.000đ","25.000đ"};

    private List<String> items = new ArrayList<>();
    private List<QuanAo> items2 = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_datdon = (Button) findViewById(R.id.btnmua);
        bt_datdon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bt_mua = new Intent(MainActivity.this, Activity_huydonhang.class);
                startActivity(bt_mua);
            }
        });

        rcvData = findViewById(R.id.rcv_data);
        rcvData1 = findViewById(R.id.rcv_data1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);
        xacnhanAdapter = new XacnhanAdapter(this,getListXacnhan());
        rcvData.setAdapter(xacnhanAdapter);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        rcvData1.setLayoutManager(linearLayoutManager1);
        thoigianAdapter = new ThoigianAdapter(getListThoigian());
        rcvData1.setAdapter(thoigianAdapter);
        
        
        simpleList	=	 (ListView)findViewById(R.id.lvquanao);
        simpleList2	=	 (RecyclerView) findViewById(R.id.rvthem);
        items.add("x1 Quần Jeen");
        items.add("x1 Quần Jeen");
        items.add("x1 Quần Jeen");
        items.add("x1 Quần Jeen");
        items2.add(new QuanAo("Quan Jeen","50.000đ",R.drawable.ao));
        items2.add(new QuanAo("Áo Thun","60.000đ",R.drawable.ao));
        items2.add(new QuanAo("Quần bò","70.000đ",R.drawable.ao));
        items2.add(new QuanAo("Quần Trâu","80.000đ",R.drawable.ao));


        simpleList2.setLayoutManager(new GridLayoutManager(this,1, GridLayoutManager.HORIZONTAL,false));
        QuanAoAdapter adapter	= 	new QuanAoAdapter( MainActivity.this, Lista,List2,flag);
        RCAdapter adapter2	= 	new RCAdapter( items2);
        simpleList.setAdapter(adapter);
        simpleList2.setAdapter(adapter2);
        
        
        

    }

    private List<Thoigian> getListThoigian() {
        List<Thoigian> list =new ArrayList<>();
        list.add(new Thoigian(R.drawable.baseline_access_time,"Thời gian giao dự kiến","Từ ngày 12/10/2023 đến ngày 19/10/2023"));
        return list;
    }

    private List<Xacnhan> getListXacnhan() {
        List<Xacnhan> list =new ArrayList<>();
        list.add(new Xacnhan(R.drawable.baseline_location,"Địa chỉ giao hàng","Lê Văn A - 012345678","48-Cao Thắng-Hải Châu-Đà Nẵng"));
        return list;
    }
}