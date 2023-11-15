package vn.com.phamthehung.viewpager2tablayoutfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    List<QuocGia> dsQuocGia;
    ViewPager2 viewPager2;
    QuocGiaPagerAdapter quocGiaPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsQuocGia = new ArrayList<>();
        QuocGia quocGia1 = new QuocGia("Việt Nam", "vn", 99);
        QuocGia quocGia2 = new QuocGia("Liên Bang Nga", "ru", 143);
        QuocGia quocGia3 = new QuocGia("Hoa Kỳ", "us", 332);
        dsQuocGia.add(quocGia1);
        dsQuocGia.add(quocGia2);
        dsQuocGia.add(quocGia3);

        viewPager2 = findViewById(R.id.viewPagerQG);
        quocGiaPagerAdapter = new QuocGiaPagerAdapter(this, dsQuocGia);

        viewPager2.setAdapter(quocGiaPagerAdapter);

        tabLayout = findViewById(R.id.tabQuocGia);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText("Country " + (position + 1))).attach();
    }
}