package com.example.app_banhangtructuyen.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.SanphamAdapter;
import com.example.app_banhangtructuyen.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTimKiem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTimKiem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Product> arrayList;
    View view;

    public FragmentTimKiem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTimKiem.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTimKiem newInstance(String param1, String param2) {
        FragmentTimKiem fragment = new FragmentTimKiem();
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
        view =  inflater.inflate(R.layout.fragment_tim_kiem, container, false);
        ShowSanPham();
        return view;
    }
    public  void ShowSanPham(){
        arrayList = new ArrayList<>();
        arrayList.add(new Product(1,"Áo khoác nam",150000,R.drawable.sanpham," ",1));
        arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
        arrayList.add(new Product(4,"Áo khoác nam",150000,R.drawable.sanpham," ",4));
        arrayList.add(new Product(5,"Áo khoác nam",150000,R.drawable.sanpham," ",5));
        arrayList.add(new Product(6,"Áo khoác nam",150000,R.drawable.sanpham," ",6));
        arrayList.add(new Product(7,"Áo khoác nam",150000,R.drawable.sanpham," ",7));
        arrayList.add(new Product(8,"Áo khoác nam",150000,R.drawable.sanpham," ",8));
        GridView recyclerView = (GridView) view.findViewById(R.id.tksanpham);

        SanphamAdapter adapter = new SanphamAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(adapter);
    }
    public void ActionBacktoHome(){
        ImageView iconback = view.findViewById(R.id.iconbackhome);
        iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentHome();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();            }
        });
    }
}