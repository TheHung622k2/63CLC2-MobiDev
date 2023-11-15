package vn.com.phamthehung.viewpager2tablayoutfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class QuocGiaFragment extends Fragment {

    private QuocGia quocGia;

    public QuocGiaFragment(QuocGia _QuocGia) {
        quocGia = _QuocGia;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewFrg = inflater.inflate((R.layout.fragment_quoc_gia), container, false);
        TextView textViewTenQG = viewFrg.findViewById(R.id.textViewCountryName);
        TextView textViewDanSo = viewFrg.findViewById(R.id.textViewPopulation);
        ImageView imageView = viewFrg.findViewById(R.id.imageViewFlag);


        textViewTenQG.setText(quocGia.getCountryName());
        textViewDanSo.setText("Dân số: " + String.valueOf(quocGia.getPopulation()) + " M");
        int resId = viewFrg.getResources().getIdentifier(quocGia.getCountryFlag(), "mipmap", viewFrg.getContext().getPackageName());
        imageView.setImageResource(resId);

        return viewFrg;
    }
}