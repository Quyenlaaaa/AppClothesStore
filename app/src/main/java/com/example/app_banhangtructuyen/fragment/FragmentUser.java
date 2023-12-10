package com.example.app_banhangtructuyen.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.activity.Admin_Activity;
import com.example.app_banhangtructuyen.activity.CaiDatActivity;
import com.example.app_banhangtructuyen.activity.DieuKhoanActivity;
import com.example.app_banhangtructuyen.activity.DonHangCuaToiActivity;
import com.example.app_banhangtructuyen.activity.HoTroActivity;
import com.example.app_banhangtructuyen.activity.HomeActivity;
import com.example.app_banhangtructuyen.activity.HosoActivity;
import com.example.app_banhangtructuyen.activity.SignInActivity;
import com.example.app_banhangtructuyen.adapter.ListItemUserAdapter;
import com.example.app_banhangtructuyen.model.UserSingleton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUser extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    ListView simpleList;
    TextView hovaten;
    String List[];
    int flags[];
    public FragmentUser() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentUser newInstance(String param1, String param2) {
        FragmentUser fragment = new FragmentUser();
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
        view = inflater.inflate(R.layout.fragment_user, container, false);
        ShowItemInUser();


        return view;
    }

    public void ShowItemInUser() {

        hovaten=(TextView)view.findViewById(R.id.hovaten);
        UserSingleton userSingleton = UserSingleton.getInstance();
        String email = userSingleton.getUsername();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        if (email.equals("admin@gmail.com")==true)
        {
           DataAdmin();
        }
        else
            DataKH();
        DatabaseReference myRef = firebaseDatabase.getReference("Khachhang");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap:snapshot.getChildren()) {
                    String emaila = snap.child("phone_email").getValue(String.class);
                    if( email.equals(emaila)==true)
                    {
                        String hoten = snap.child("hoTen").getValue(String.class);
                        hovaten.setText(hoten);

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        simpleList = (ListView) view.findViewById(R.id.list);
        ListItemUserAdapter adapter = new ListItemUserAdapter(getActivity(), List, flags);
        simpleList.setAdapter(adapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent myintent = new Intent(getActivity(), HosoActivity.class);
                        startActivity(myintent);
                        break;
                    case 1:
                        Intent myintent1 = new Intent(getActivity(), DonHangCuaToiActivity.class);
                        startActivity(myintent1);
                        break;
                    case 2:
                        Intent myintent2 = new Intent(getActivity(), CaiDatActivity.class);
                        startActivity(myintent2);
                        break;
                    case 3:
                        Intent myintent3 = new Intent(getActivity(), HoTroActivity.class);
                        startActivity(myintent3);
                        break;
                    case 4:

                        if (email.equals("admin@gmail.com")==true)
                        {
                            Intent myintent4 = new Intent(getActivity(), Admin_Activity.class);
                            startActivity(myintent4);
                        }
                        else {
                            Intent myintent4 = new Intent(getActivity(), DieuKhoanActivity.class);
                            startActivity(myintent4);
                        }
                        break;
                    case 5:
                        OpenDia(Gravity.CENTER);
                        break;


                }


            }
        });
    }
    public void OpenDia (int gravity)
    {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_tbdangxuat);
        Window window =dialog.getWindow();
        if(window==null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams wda= window.getAttributes();
        wda.gravity= gravity;
        window.setAttributes(wda);
        if(Gravity.BOTTOM==gravity)
        {
            dialog.setCancelable(true);

        } else
            dialog.setCancelable(false);
        Button btno = dialog.findViewById(R.id.btno);
        Button btyes = dialog.findViewById(R.id.btyes);
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
    public  void  DataKH() {
         List =new String[] {"Hồ sơ","Đơn hàng của tôi", "Cài Đặt", "Hỗ trợ", "Về chúng tôi", "Đăng xuất"};
         flags = new int[]{R.drawable.group,R.drawable.iconcart, R.drawable.gear, R.drawable.headphones, R.drawable.warningoctagon, R.drawable.signout};
    }
    public void  DataAdmin()
    {
        List =new String[]{"Hồ sơ","Đơn hàng của tôi", "Cài Đặt", "Hỗ trợ", "Quản lý", "Đăng xuất"};
        flags = new int[] {R.drawable.group,R.drawable.iconcart, R.drawable.gear, R.drawable.headphones, R.drawable.gear, R.drawable.signout};
    }
}

