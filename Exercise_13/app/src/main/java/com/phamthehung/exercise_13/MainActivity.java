package com.phamthehung.exercise_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText dk_soA, dk_soB;
    TextView dk_KetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControls();
    }

    public void findControls() {
        dk_soA = findViewById(R.id.edtA);
        dk_soB = findViewById(R.id.edtB);
        dk_KetQua = findViewById(R.id.tvKetQua);
    }

    public void Cong(View view) {
        int soA = Integer.parseInt(dk_soA.getText().toString());
        int soB = Integer.parseInt(dk_soB.getText().toString());
        int kq = soA + soB;
        dk_KetQua.setText(String.valueOf(kq));
    }

    public void Tru(View view) {
        int soA = Integer.parseInt(dk_soA.getText().toString());
        int soB = Integer.parseInt(dk_soB.getText().toString());
        int kq = soA - soB;
        dk_KetQua.setText(String.valueOf(kq));
    }

    public void Nhan(View view) {
        int soA = Integer.parseInt(dk_soA.getText().toString());
        int soB = Integer.parseInt(dk_soB.getText().toString());
        int kq = soA * soB;
        dk_KetQua.setText(String.valueOf(kq));
    }

    public void Chia(View view) {
        int soA = Integer.parseInt(dk_soA.getText().toString());
        int soB = Integer.parseInt(dk_soB.getText().toString());
        if (soB == 0) {
            Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
        } else {
            int kq = soA / soB;
            dk_KetQua.setText(String.valueOf(String.valueOf(kq)));
        }
    }
}