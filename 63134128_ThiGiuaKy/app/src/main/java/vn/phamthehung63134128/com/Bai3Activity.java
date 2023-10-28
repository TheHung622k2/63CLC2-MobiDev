package vn.phamthehung63134128.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Bai3Activity extends AppCompatActivity {
    ArrayList<Country> dsQuocGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        dsQuocGia = new ArrayList<>();
        Country nation1 = new Country("Việt Nam", "vn", 98000000);
        Country nation2 = new Country("United State", "us", 320000000);
        Country nation3 = new Country("Russia", "ru", 142000000);

        dsQuocGia.add(nation1);
        dsQuocGia.add(nation2);
        dsQuocGia.add(nation3);

        ListView listViewQG = findViewById(R.id.listViewNATION);

        CountryAdapter adapter = new CountryAdapter(dsQuocGia, this);

        listViewQG.setAdapter(adapter);

        listViewQG.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Lấy quốc gia được chọn
                Country selectedCountry = dsQuocGia.get(i);

                // Hiển thị thông tin của quốc gia
                String countryInfo = "Tên: " + selectedCountry.getCountryName() + "\n"
                        + "Dân số: " + selectedCountry.getPopulation();

                // Hiển thị thông tin bằng cửa sổ thông báo
                AlertDialog.Builder builder = new AlertDialog.Builder(Bai3Activity.this);
                builder.setTitle("Thông tin quốc gia");
                builder.setMessage(countryInfo);
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}