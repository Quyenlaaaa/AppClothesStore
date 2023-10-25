package com.example.gourav.appclothesstore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView backButton;
    private TextView titleText;
    private TextView productName;
    private RatingBar ratingBar;
    private EditText reviewText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần trong giao diện
        backButton = findViewById(R.id.backButton);
        titleText = findViewById(R.id.titleText);
        productName = findViewById(R.id.productName);
        ratingBar = findViewById(R.id.ratingBar);
        reviewText = findViewById(R.id.reviewText);
        submitButton = findViewById(R.id.submitButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                String review = reviewText.getText().toString();

                Toast.makeText(MainActivity.this, "Đánh giá của bạn đã được gửi!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}