package com.phamthehung.customizedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> dsQuocGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Chuẩn bị dữ liệu, vd hard-code
        dsQuocGia = new ArrayList<Country>();
        Country nation1 = new Country("Việt Nam", "vn", 98000000);
        Country nation2 = new Country("United State", "us", 320000000);
        Country nation3 = new Country("Russia", "ru", 142000000);

        dsQuocGia.add(nation1);
        dsQuocGia.add(nation2);
        dsQuocGia.add(nation3);
        // Tìm điều khiển
        ListView listViewQG = findViewById(R.id.listViewNATION);
        // Tạo adapter
        CountryAdapter adapter = new CountryAdapter(dsQuocGia, this);
        // Gán adapter
        listViewQG.setAdapter(adapter);
        // Xử lý sự kiện: như thông thường
    }
}