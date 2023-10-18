package com.phamthehung.vidubolangnghe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText dk_Name;
    Button dk_SayHi, dk_XinChao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControls();

        // Cài đặt bộ lắng nghe và xử lý sự kiện cho mỗi nút
        dk_SayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code xử lý ở đây
                String strName = dk_Name.getText().toString();
                // Xuất theo yêu cầu
                String strThongBao = "Nice to see you \n" + strName;
                Toast.makeText(getBaseContext(), strThongBao, Toast.LENGTH_SHORT).show();
            }
        });
        dk_XinChao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = dk_Name.getText().toString();
                String strThongBao = "Chào bạn \n" + strName;
                Toast.makeText(MainActivity.this, strThongBao, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void findControls() {
        dk_Name = findViewById(R.id.edtName);
        dk_SayHi = findViewById(R.id.btnSayHi);
        dk_XinChao = findViewById(R.id.btnXinChao);
    }
}