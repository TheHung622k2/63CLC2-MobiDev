package vn.phamthehung63134128.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bai2Activity extends AppCompatActivity {
    ArrayList<String> dsThienDuongNhietDoi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        findControls();

        dsThienDuongNhietDoi.add("Bora Bora, Pháp");
        dsThienDuongNhietDoi.add("Zanzibar, Châu Phi");
        dsThienDuongNhietDoi.add("Kauai, Hawaii");
        dsThienDuongNhietDoi.add("Palawan, Philippines");
        dsThienDuongNhietDoi.add("Ischia, Italy");
        dsThienDuongNhietDoi.add("Cape Breton, Canada");
        dsThienDuongNhietDoi.add("Hvar, Croatia");
        dsThienDuongNhietDoi.add("Hokkaido, Nhật Bản");
        dsThienDuongNhietDoi.add("Cano Cristales, Colombia");
        dsThienDuongNhietDoi.add("Travertine, Pamukkale");

        ArrayAdapter<String> adapterTD;
        adapterTD = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsThienDuongNhietDoi);

        listViewParadise.setAdapter(adapterTD);

        listViewParadise.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemChon = dsThienDuongNhietDoi.get(i);
                String thongBao = "Thiên đường: " + itemChon;
                Toast.makeText(Bai2Activity.this, thongBao, Toast.LENGTH_SHORT).show();
            }
        });
    }


    void findControls() {
        listViewParadise = findViewById(R.id.lvParadise);
    }
    ListView listViewParadise;
}