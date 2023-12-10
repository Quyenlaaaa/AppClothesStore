package com.example.app_banhangtructuyen.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.activity.XacNhanDonHangActivity;
import com.example.app_banhangtructuyen.adapter.GiohangAdapter;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;
import com.example.app_banhangtructuyen.model.ShoppingCart;
import com.example.app_banhangtructuyen.model.ShoppingCartSingleton;
import com.example.app_banhangtructuyen.model.UserSingleton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
    GiohangAdapter adapter;
    ArrayList<ItemCart> arrayList;
    double tongtien;
    ShoppingCart shoppingCart;
    GridView gridView;
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
        gridView = (GridView) view.findViewById(R.id.grvgiohang);
        UserSingleton userSingleton = UserSingleton.getInstance();
        String email = userSingleton.getUsername();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Cart");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap:snapshot.getChildren()) {
                    String emaila = snap.child("user").getValue(String.class);
                    if( email.equals(emaila)==true) {
                        Product pr =snap.child("cartItems/0/product").getValue(Product.class);
                        Integer quan=snap.child("cartItems/0/quantity").getValue(Integer.class);
                        shoppingCart.addItem(pr,quan);

                       //Toast.makeText(getContext(), pr.getTenSP(), Toast.LENGTH_SHORT).show();
                       // arrayList.add(new ItemCart(pr,1));
                        arrayList = shoppingCart.getCartItems();
//
                    }
                }
                try {
                    adapter = new GiohangAdapter(getActivity(), arrayList);
                    gridView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    //adapter.notifyDataSetChanged();
                }
                catch (Exception e) {
                    Toast.makeText(getActivity(), "Chua co gio hang", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






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