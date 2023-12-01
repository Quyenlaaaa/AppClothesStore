package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_banhangtructuyen.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SignUpActivity extends AppCompatActivity {

    private View iconback;
    private TextInputLayout editHoTen, editDiaChi, editEmail, editPassword, editNhapLaiPass;
    private Button btnSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        editHoTen = findViewById(R.id.edithoten);
        editDiaChi= findViewById(R.id.editdiachi);
        editEmail = findViewById(R.id.editemail);
        editPassword = findViewById(R.id.editpass);
        editNhapLaiPass = findViewById(R.id.editnhaplaipass);
        btnSignUp = findViewById(R.id.signup);
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
        String hoTen = editHoTen.getEditText().toString();
        String diaChi = editDiaChi.getEditText().toString();
        String email = editEmail.getEditText().getText().toString().trim();
        String password = editPassword.getEditText().getText().toString().trim();
        String nhapLaiPass = editNhapLaiPass.getEditText().getText().toString().trim();

        if (TextUtils.isEmpty(hoTen) || TextUtils.isEmpty(diaChi)
                || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(nhapLaiPass)) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(nhapLaiPass)) {
            Toast.makeText(this, "Nhập lại mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                            finish();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Lỗi nhập liệu! Vui lòng đăng ký lại!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
