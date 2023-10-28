package com.phamthehung.vidu2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NhapLieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_lieu);
    }

    // Bước 4: Xử lý ở màn hình nhập liệu
    public void Nhap_QuayVe(View v) {
        EditText edHT = findViewById(R.id.edHoTen);
        EditText edNS = findViewById(R.id.edNamSinh);
        // Lấy dữ liệu
        String hoTen = edHT.getText().toString();
        int namSinh = Integer.parseInt(edNS.getText().toString());
        // Tạo mới Intent
        Intent iKQnhapLieu = new Intent();
        // Đưa dữ liệu vào Intent để gửi về
        // Dữ liệu được đưa vào ở dạng KEY (name) --> Value
        iKQnhapLieu.putExtra("HT", hoTen); // HT là key do ta đặt, dùng để truy xuất/ bóc dữ liệu ở bên nhận
        iKQnhapLieu.putExtra("NS", namSinh); // tương tự cho NS
        // Gửi kết quả trả về cho Activity đã gọi nó
        setResult(RESULT_OK, iKQnhapLieu);
        // Đóng Activity nhập liệu (này)
        finish();
    }
}