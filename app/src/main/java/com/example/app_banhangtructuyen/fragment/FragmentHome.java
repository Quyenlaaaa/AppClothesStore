package com.example.app_banhangtructuyen.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.activity.DetailActivity;
import com.example.app_banhangtructuyen.adapter.ProductSearchAdapter;
import com.example.app_banhangtructuyen.adapter.SanphamAdapter;
import com.example.app_banhangtructuyen.model.Category;
import com.example.app_banhangtructuyen.model.Product;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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


    private AutoCompleteTextView atcProductSearch;
    List<Product> arrayList;
    ArrayList<Category> categorylist;
    SanphamAdapter adapter;
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
        ShowSanPham(1);
        ClickItemSanPham();
        atcProductSearch = view.findViewById(R.id.atc_product_search);

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
        categorylist = new ArrayList<>();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("Danhmuc");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap: snapshot.getChildren()){
                    Category dm = snap.getValue(Category.class);
                    categorylist.add(dm);
                    //Toast.makeText(getContext(), String.valueOf(dm.getMaDm()), Toast.LENGTH_SHORT).show();
                }
                for (Category category : categorylist) {
                    TabLayout.Tab tab = tabLayout.newTab();
                    // Tạo một customView từ layout được định nghĩa trong item_categories
                    View customView = LayoutInflater.from(getActivity()).inflate(R.layout.item_categories, null);
                    // Đặt nội dung cho TextView trong customView từ category.getTenDM()
                    TextView customTextView = customView.findViewById(R.id.tabText);
                    customTextView.setText(category.getTenDM());
                    tab.setTag(category.getMaDm());
                    // Đặt customView cho tab
                    tab.setCustomView(customView);
                    // Thêm tab vào tabLayout
                    tabLayout.addTab(tab);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int maDanhMuc = (int) tab.getTag();
                ShowSanPham(maDanhMuc);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void setProductSearchAdapter(List<Product> arrayList ){
        ProductSearchAdapter productSearchAdapter = new ProductSearchAdapter(getActivity(),R.layout.item_search, arrayList);
        atcProductSearch.setAdapter(productSearchAdapter);
        atcProductSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product selectProduct = arrayList.get(i);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("selectProduct", selectProduct);
                //Toast.makeText(getContext(), selectProduct.getTenSP(), Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });
    }

    public  void ShowSanPham(int madm){
        arrayList = new ArrayList<>();
        GridView recyclerView = (GridView) view.findViewById(R.id.listsanpham);
        adapter = new SanphamAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(adapter);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("Sanpham");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for (DataSnapshot snap : snapshot.getChildren()){
                    Product sp = snap.getValue(Product.class);
                    if(sp.getMaDM() == madm ){
                        arrayList.add(sp);
                    }
                    //Toast.makeText(getContext(), sp.getTenSP(), Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();
                setProductSearchAdapter(arrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public  void ClickItemSanPham(){
        GridView recyclerView = (GridView) view.findViewById(R.id.listsanpham);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product selectProduct = arrayList.get(i);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("selectProduct", selectProduct);
                //Toast.makeText(getContext(), selectProduct.getTenSP(), Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });
    }




}