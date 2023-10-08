package com.phamthehung.appcacpheptoansohoccoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText dk_soA, dk_soB;
    TextView dk_KQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControls();
    }
    void findControls() {
        dk_soA = findViewById(R.id.edtA);
        dk_soB = findViewById(R.id.edtB);
        dk_KQ = findViewById(R.id.tvResult);
    }
    // Hàm xử lý sự kiện click lên nút "+"
    public void XuLy_Cong(View v) {
        // Lấy số thứ nhất
            // Tìm điều khiển chứa dữ liệu số A
            EditText dk_soA = findViewById(R.id.edtA);
            // Lấy dữ liệu chứa trong điều khiển, chuyển sang kiểu số nguyên
            int soA = Integer.parseInt(dk_soA.getText().toString());
        // Lấy số thứ hai
            EditText dk_soB = findViewById(R.id.edtB);
            int soB = Integer.parseInt(dk_soB.getText().toString());
            // Xử lý
            int KetQua = soA + soB;
        // Hiện kết quả
            // Tìm điều khiển chứa kết quả
            TextView dk_KQ = findViewById(R.id.tvResult);
            // Quy định text cho điều khiển này là kết quả tính toán được
            // Chú ý: Chuyển sang kiểu Chuỗi trước khi set
            dk_KQ.setText(String.valueOf(KetQua));
    }
    // Hàm xử lý sự kiện click lên nút "-"
    public void XuLy_Tru(View v) {
        int soA = Integer.parseInt(dk_soA.getText().toString());
        int soB = Integer.parseInt(dk_soB.getText().toString());
        int KetQua = soA - soB;
        dk_KQ.setText(String.valueOf(KetQua));
    }
    // Hàm xử lý sk click lên nút "*"
    public void XuLy_Nhan(View v) {
        int soA = Integer.parseInt(dk_soA.getText().toString());
        int soB = Integer.parseInt(dk_soB.getText().toString());
        int KetQua = soA * soB;
        dk_KQ.setText(String.valueOf(KetQua));
    }
    // Hàm xử lý sk click lên nút "/"
    public void XuLy_Chia(View v) {
        int soA = Integer.parseInt(dk_soA.getText().toString());
        int soB = Integer.parseInt(dk_soB.getText().toString());
        if (soB == 0) {
            Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            int KetQua = soA / soB;
            dk_KQ.setText(String.valueOf(KetQua));
        }
    }
}