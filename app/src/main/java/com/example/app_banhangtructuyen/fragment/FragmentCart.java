package com.example.app_banhangtructuyen.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.activity.XacNhanDonHangActivity;
import com.example.app_banhangtructuyen.adapter.GiohangAdapter;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.ShoppingCart;
import com.example.app_banhangtructuyen.model.ShoppingCartSingleton;

import java.text.DecimalFormat;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCart extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View view;
    double tongtien;
    ShoppingCart shoppingCart;

    public FragmentCart() {
        // Required empty public constructor
    }
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
        shoppingCart = ShoppingCartSingleton.getInstance().getShoppingCart();
        ShowlistSanPhamGioHang();
        tongtien = shoppingCart.getCountItemCart();
        TextView txttongtien = view.findViewById(R.id.tonggiatien);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien)+" đ");
        return view;
    }

    private void ShowlistSanPhamGioHang() {
        GridView gridView = (GridView) view.findViewById(R.id.grvgiohang);
        List<ItemCart> arrayList = shoppingCart.getCartItems();
        GiohangAdapter adapter = new GiohangAdapter(getActivity(),arrayList);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

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