package vn.phamthehung63134128.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Bai1(View v) {
        Intent iBai1 = new Intent(this, Bai1Activity.class);
        startActivity(iBai1);
    }

    public void Bai2(View v) {
        Intent iBai2 = new Intent(this, Bai2Activity.class);
        startActivity(iBai2);
    }

    public void Bai3(View v) {
        Intent iBai3 = new Intent(this, Bai3Activity.class);
        startActivity(iBai3);
    }

    public void Bai4(View v) {
        Intent iBai4 = new Intent(this, Bai4Activity.class);
        startActivity(iBai4);
    }
}