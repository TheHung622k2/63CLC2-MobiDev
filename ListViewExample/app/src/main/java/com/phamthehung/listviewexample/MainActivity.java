package com.phamthehung.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsBaiHat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bước 0: Tìm điều khiển
        findControls();
        // Bước 1: Chuẩn bị list dữ liệu
        dsBaiHat = new ArrayList<>();
        dsBaiHat.add("Bắc kim thang");
        dsBaiHat.add("Tiến quân ca");
        dsBaiHat.add("Dòng máu Lạc Hồng");
        dsBaiHat.add("Chúc mừng sinh nhật");
        dsBaiHat.add("Em ơi Hà Nội vắng");
        dsBaiHat.add("Biển tình");
        dsBaiHat.add("Bài thánh ca buồn");
        // Bước 2: Tạo Adapter
        ArrayAdapter<String> adapterBH;
        adapterBH = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsBaiHat);
        // Bước 3: Gắn Adapter
        listViewBaiHat.setAdapter(adapterBH);
        // Bước 4: Bắt sự kiện để xử lý
        listViewBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i là vị trí của mục vừa được chọn
                // xử lý: vd ta lấy về bài ta vừa chọn
                /*String itemChon = adapterBH.getItem(i);*/
                // hoặc ta có thể lấy từ nguồn dữ liệu
                String itemChon = dsBaiHat.get(i);
                // in thông báo ra màn hình
                String thongBao = "Bạn chọn bài: " + itemChon;
                Toast.makeText(MainActivity.this, thongBao, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void findControls() {
        listViewBaiHat = findViewById(R.id.lvBaiHat);
    }
    ListView listViewBaiHat;
}