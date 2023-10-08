package com.phamthehung.apptinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText dk_Weight, dk_Height;
    TextView dk_bmi, dk_ketluan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControls();
    }

    void findControls() {
        dk_Weight = findViewById(R.id.edt_Weight);
        dk_Height = findViewById(R.id.edt_Height);
        dk_bmi = findViewById(R.id.tvBMI);
        dk_ketluan = findViewById(R.id.tvKetLuan);
    }

    public void Tinh_BMI_click(View view) {
        float weight = Float.parseFloat(dk_Weight.getText().toString());
        float height = Float.parseFloat(dk_Height.getText().toString());
        String result;

        // Chuyển chiều cao thành m
        height /= 100;

        float bmi = weight / (height * height);

        // Làm tròn số thập phân
        DecimalFormat df = new DecimalFormat("#.0");
        df.format(bmi);

        dk_bmi.setText(String.valueOf(bmi));

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

        dk_ketluan.setText(result);
    }
}