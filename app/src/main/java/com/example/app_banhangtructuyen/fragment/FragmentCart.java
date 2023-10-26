package com.example.app_banhangtructuyen.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.activity.XacNhanDonHangActivity;
import com.example.app_banhangtructuyen.adapter.GiohangAdapter;
import com.example.app_banhangtructuyen.model.Product;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCart extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    Integer so;

    public FragmentCart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCart.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCart newInstance(String param1, String param2) {
        FragmentCart fragment = new FragmentCart();
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
        view =  inflater.inflate(R.layout.fragment_cart, container, false);
        ShowlistSanPhamGioHang();
        return view;
    }

    private void ShowlistSanPhamGioHang() {

        GridView gridView = (GridView) view.findViewById(R.id.grvgiohang);
        ArrayList arrayList = new ArrayList<>();

        arrayList.add(new Product(1,"Áo khoác nam",150000,R.drawable.sanpham," ",1));
        arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
        arrayList.add(new Product(4,"Áo khoác nam",150000,R.drawable.sanpham," ",4));
        GiohangAdapter adapter = new GiohangAdapter(getActivity(),arrayList);
        gridView.setAdapter(adapter);

        AppCompatButton btn = view.findViewById(R.id.muangay);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), XacNhanDonHangActivity.class);
                startActivity(intent);
            }
        });
    }


}