package com.example.app_banhangtructuyen.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.activity.DetailActivity;
import com.example.app_banhangtructuyen.activity.TimKiemActivity;
import com.example.app_banhangtructuyen.adapter.SanphamAdapter;
import com.example.app_banhangtructuyen.model.Product;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    List<Product> arrayList;
    public FragmentHome() {
        // Required empty public constructor
    }
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_home, container, false);
        ActionViewFlipper();
        ActionCategory();
        ShowSanPham();
        ActionTimKiem();
        ActionClickTapDanhMuc();
        ClickItemSanPham();


        return view;


    }
    public void ActionViewFlipper(){
        ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.viewflipper);
        int[] arrayBanner = {R.drawable.banner3,R.drawable.banner2, R.drawable.banner4};
        for (int i=0; i< arrayBanner.length; i++){
            ImageView imageView = new ImageView(getActivity().getApplicationContext());
            imageView.setImageResource(arrayBanner[i]);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        Animation slide_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_out_right);

        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }
    public void ActionCategory(){
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.danhmuc);
        ArrayList<String> categorylist = new ArrayList<>();
        categorylist.add("Tất cả");
        categorylist.add("Quần Jeans");
        categorylist.add("Áo sơ mi");
        categorylist.add("Quần Tây");
        categorylist.add("Áo phông");
        for(String categoryname: categorylist){
            TabLayout.Tab tab= tabLayout.newTab();
            View customView = LayoutInflater.from(getActivity()).inflate(R.layout.item_categories, null);
            tab.view.setLayoutParams(new LinearLayout.LayoutParams(1000,LinearLayout.LayoutParams.WRAP_CONTENT));
            // Tìm TextView trong customView và đặt nội dung từ categoryName
            TextView customTextView = customView.findViewById(R.id.tabText);
            customTextView.setText(categoryname);

            tab.setCustomView(customView);

            tabLayout.addTab(tab);

        }

    }
    public void ActionClickTapDanhMuc(){
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.danhmuc);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ShowSanPham();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ShowSanPham();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                ShowSanPham();
            }
        });
    }

    public void ActionTimKiem(){
        ImageView iconsearch = view.findViewById(R.id.iconsearch);
        iconsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TimKiemActivity.class);
                startActivity(intent);
            }
        });
    }
    public  void ShowSanPham(){
        arrayList = new ArrayList<>();
        arrayList.add(new Product(1,"Áo khoác nam",150000,R.drawable.sanpham," ",1));
        arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
        arrayList.add(new Product(4,"Áo khoác nam",150000,R.drawable.sanpham," ",4));
        arrayList.add(new Product(5,"Áo khoác nam",150000,R.drawable.sanpham," ",5));
        arrayList.add(new Product(6,"Áo khoác nam",150000,R.drawable.sanpham," ",6));
        GridView recyclerView = (GridView) view.findViewById(R.id.listsanpham);

        SanphamAdapter adapter = new SanphamAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(adapter);


    }
    public  void ClickItemSanPham(){
        GridView recyclerView = (GridView) view.findViewById(R.id.listsanpham);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                        startActivity(intent);

            }
        });
    }

}