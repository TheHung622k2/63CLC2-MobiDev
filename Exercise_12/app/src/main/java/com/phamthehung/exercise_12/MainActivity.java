package com.phamthehung.exercise_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText dk_Height, dk_Weight;
    TextView dk_BMI, dk_KetLuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControls();
    }

    public void findControls() {
        dk_Height = findViewById(R.id.edtHeight);
        dk_Weight = findViewById(R.id.edtWeight);
        dk_BMI = findViewById(R.id.tvBMI);
        dk_KetLuan = findViewById(R.id.tv_KetLuan);
    }

    public void Tinh_BMI_Click(View view) {
        float height = Float.parseFloat(dk_Height.getText().toString());
        float weight = Float.parseFloat(dk_Weight.getText().toString());
        String result;

        // Chuyển chiều cao thành m
        height /= 100;

        float bmi = weight / (float) Math.pow(height, 2);

        // Làm tròn số thập phân
        DecimalFormat df = new DecimalFormat("#.0");
        df.format(bmi);

        dk_BMI.setText(String.valueOf(bmi));

        if (bmi < 18.5) {
            result = "Gầy";
        } else if (18.5 <= bmi && bmi <= 24.9) {
            result = "Bình thường";
        } else if (bmi == 25.0) {
            result = "Thừa cân";
        } else if (25 < bmi && bmi <= 29.9) {
            result = "Tiền béo phì";
        } else if (30 <= bmi && bmi <= 34.9) {
            result = "Béo phì độ I";
        } else {
            result = "Béo phì độ II";
        }

        dk_KetLuan.setText(result);

    }
}