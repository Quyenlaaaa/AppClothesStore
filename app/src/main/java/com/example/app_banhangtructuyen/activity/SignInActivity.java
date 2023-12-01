package com.example.app_banhangtructuyen.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_banhangtructuyen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private EditText editemailPhone, editPassword;
    private Button btsignin;
    private TextView txtsignup;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        fAuth = FirebaseAuth.getInstance();
        editemailPhone = findViewById(R.id.editPhoneInput);
        editPassword = findViewById(R.id.editPasswordInput);
        btsignin = findViewById(R.id.appCompatButton);
        txtsignup = findViewById(R.id.txtsignup);

        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signIn() {
        String email_phone,pass;
        email_phone=editemailPhone.getText().toString();
        pass=editPassword.getText().toString();

        if(TextUtils.isEmpty(email_phone) || TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Eamil/Số điện thoại hoặc mật khẩu trống!", Toast.LENGTH_SHORT).show();
            return;
        }
        fAuth.signInWithEmailAndPassword(email_phone, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignInActivity.this, "Đănng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(SignInActivity.this, "Email/Số điện thoại hoặc mật khẩu sai!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
