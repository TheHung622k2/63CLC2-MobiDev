package com.phamthehung.vidu2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Bước 2: Xây dựng hàm xử lý đáp ứng sự kiện onClick Mở màn hình nhập liệu (MainActivity)
    // Hàm đáp ứng sự kiện Onclick lên nút "Mở màn hình nhập liệu"
    public void NhapLieu(View v) {
        // Tạo mới một Intent
        Intent iNhap = new Intent(this, NhapLieuActivity.class);
        // Chuyển sang màn hình nhập liệu
        // Nhưng có đợi kết quả trả về, mã của yêu cầu này ta đặt là 8000 chẳng hạn
        startActivityForResult(iNhap, 8000);
    }

    // Bước 3: Ghi đè phương thức
    //@Override
    //protected void onActivityResult(int requestCode, int resultCode, Intent data)
    //để xử lý kết quả nhận được (dữ liệu trả về từ màn hình nhập liệu)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 8000)
            if (resultCode == RESULT_OK) {
                // Lấy dữ liệu gửi về
                // Ở đây, ta chú ý, dữ liệu được gửi về theo cặp Key(Name)--Value
                // Ta bóc dữ liệu ra theo Key
                String hoTenNhanDuoc = data.getStringExtra("HT"); // HT là key ta đặt ở Activity nhập liệu
                int namSinhNhanDuoc = data.getIntExtra("NS", 2020); // NS là key ta đặt ở Activity nhập liệu
                // Đưa lên điều khiển ta muốn hiện kết quả nhận được
                TextView tvHT = findViewById(R.id.tvHoTen);
                TextView tvNS = findViewById(R.id.tvNamSinh);
                tvHT.setText(hoTenNhanDuoc);
                tvNS.setText(String.valueOf(namSinhNhanDuoc));
            } else
                Toast.makeText(this, "Trả về thất bại", Toast.LENGTH_LONG).show();
        else
            super.onActivityResult(requestCode, resultCode, data);
    }
}