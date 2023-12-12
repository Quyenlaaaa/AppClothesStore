package com.example.app_banhangtructuyen.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.UserSingleton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private EditText editemailPhone, editPassword;
    private Button btsignin;
    private CheckBox checkSave;
    private TextView txtsignup;
    private FirebaseAuth fAuth;
    private String SaveAccount = "email_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        fAuth = FirebaseAuth.getInstance();
        editemailPhone = findViewById(R.id.editPhoneInput);
        editPassword = findViewById(R.id.editPasswordInput);
        checkSave = findViewById(R.id.checkboxSave);
        checkSave.setChecked(true);
        btsignin = findViewById(R.id.appCompatButton);
        loadSaved();

        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save credentials only if the checkbox is checked
                if (checkSave.isChecked()) {
                    saveCredentials();
                }
                signIn();
            }
        });

        txtsignup = findViewById(R.id.txtsignup);
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signIn() {
        String email_phone = editemailPhone.getText().toString();
        String pass = editPassword.getText().toString();
        UserSingleton userSingleton = UserSingleton.getInstance();
        userSingleton.setUsername(email_phone);

        if (TextUtils.isEmpty(email_phone) || TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Email/Số điện thoại hoặc mật khẩu trống!", Toast.LENGTH_SHORT).show();
            return;
        }

        fAuth.signInWithEmailAndPassword(email_phone, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignInActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignInActivity.this, "Email/Số điện thoại hoặc mật khẩu sai!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveCredentials() {
        SharedPreferences sharedPreferences = getSharedPreferences(SaveAccount, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", editemailPhone.getText().toString());
        editor.putString("Password", editPassword.getText().toString());
        editor.apply();
    }

    private void loadSaved() {
        SharedPreferences sharedPreferences = getSharedPreferences(SaveAccount, MODE_PRIVATE);
        String savedEmail = sharedPreferences.getString("Email", "");
        String savedPassword = sharedPreferences.getString("Password", "");

        editemailPhone.setText(savedEmail);
        editPassword.setText(savedPassword);
    }
}
