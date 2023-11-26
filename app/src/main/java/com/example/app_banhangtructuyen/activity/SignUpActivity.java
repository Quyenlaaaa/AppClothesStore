package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.app_banhangtructuyen.R;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.app_banhangtructuyen.model.KhachhangClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private View iconback;
    private TextInputLayout editHoTen, editDiaChi, editPhoneorEmail, editPassword, editNhapLaiPass;
    private Button btnSignUp;
    private FirebaseAuth fAuth;
    FirebaseDatabase firestore;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fAuth = FirebaseAuth.getInstance();
        editHoTen = findViewById(R.id.edithoten);
        editDiaChi= findViewById(R.id.editdiachi);
        editPhoneorEmail = findViewById(R.id.editemail);
        editPassword = findViewById(R.id.editpass);
        editNhapLaiPass = findViewById(R.id.editnhaplaipass);
        btnSignUp = findViewById(R.id.signup);
        fAuth = FirebaseAuth.getInstance();
        firestore = FirebaseDatabase.getInstance();
        re_signin();
        iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }
    private void re_signin() {
        iconback = (View) findViewById(R.id.iconback_signup);
    }

    private void signUp() {
        String hoTen = editHoTen.getEditText().getText().toString();
        String diaChi = editDiaChi.getEditText().getText().toString();
        String phone_email = editPhoneorEmail.getEditText().getText().toString().trim();
        String password = editPassword.getEditText().getText().toString().trim();
        String nhapLaiPass = editNhapLaiPass.getEditText().getText().toString().trim();

        if (TextUtils.isEmpty(hoTen) || TextUtils.isEmpty(diaChi)
                || TextUtils.isEmpty(phone_email) || TextUtils.isEmpty(password)
                || TextUtils.isEmpty(nhapLaiPass)) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6 || nhapLaiPass.length() < 6) {
            Toast.makeText(this, "Mật khẩu phải có ít nhất 6 ký tự!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(nhapLaiPass)) {
            Toast.makeText(this, "Nhập lại mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
            return;
        }
        fAuth.createUserWithEmailAndPassword(phone_email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    firestore = FirebaseDatabase.getInstance();
                    reference = firestore.getReference("Khachhang");
                    //Tạo chuỗi tự động làm id
                    DatabaseReference newRef = reference.push();
                    KhachhangClass kh = new KhachhangClass(hoTen, phone_email, password, diaChi);
                    newRef.setValue(kh);
                    Toast.makeText(SignUpActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, "Lỗi nhập liệu! Vui lòng đăng ký lại!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
