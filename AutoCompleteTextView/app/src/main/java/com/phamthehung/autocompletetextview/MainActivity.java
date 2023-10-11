package com.phamthehung.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsQuocGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Buoc 0:
        findControls();
        // Buoc 1: Chuan bi nguon du lieu, cat vao bien
        dsQuocGia = new ArrayList<String>();
        dsQuocGia.add("Viet Nam");
        dsQuocGia.add("England");
        dsQuocGia.add("USA");
        dsQuocGia.add("Albania");
        dsQuocGia.add("Algeria");
        // Buoc 2: Tao adapter
        ArrayAdapter<String> adapterQG;
        adapterQG = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dsQuocGia); // Bo cuc nguon du lieu
        // Buoc 3: Gan adapter
        autoQUOCGIA.setAdapter(adapterQG);
    }

    public void findControls() {
        autoQUOCGIA = findViewById(R.id.autoCompleteQUOCGIA);
    }
    AutoCompleteTextView autoQUOCGIA;
}