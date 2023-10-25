package com.phamthehung.vidu1_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_one);
    }
    // Hàm đáp ứng sự kiện nhấn lên nút "Quay về trang chủ"
    // Xử lý chuyển về màn hình trang chủ
    public void QuayVe(View v) {
        // Tạo một đối tượng Intent
        // Tham số t2 của hàm tạo này, là tên Activity (màn hình) ta muốn chuyển sang
        Intent iManHinhChinh = new Intent(this, MainActivity.class);
        // Thực hiện chuyển
        startActivity(iManHinhChinh);
    }
}