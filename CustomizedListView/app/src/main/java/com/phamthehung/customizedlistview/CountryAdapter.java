package com.phamthehung.customizedlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// Bước 3: Xây dựng Adapter
public class CountryAdapter extends BaseAdapter {
    // Khai báo các thuộc tính của lớp
    private ArrayList<Country> dsQuocGia; // nguồn dữ liệu
    private Context context;
    private LayoutInflater inflater; // Mapping xml -> java

    // Constructor
    public CountryAdapter(ArrayList<Country> dsQuocGia, Context context) {
        this.dsQuocGia = dsQuocGia;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    // Xây dựng một lớp Holder để chứa các điều khiển tìm được từ file .xml
    class ControlHolder { // tương ứng với file item layout
        ImageView imageViewFlag;
        TextView textViewName;
        TextView textViewPopulation;
    }

    @Override
    public int getCount() {
        return dsQuocGia.size();
    }

    @Override
    public Object getItem(int i) {
        return dsQuocGia.get(i);
    }

    @Override
    public long getItemId(int i) { // chưa dùng đến, không cần quan tâm
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // get Item's View for setting data (lấy view về để gán dữ liệu cho item)
        ControlHolder itemControlsHolder; // để trữ (store) các tham chiếu (refs) đến file .xml
        if (view == null) { // inflate (bơm) from layout file "item_layout_country.xml"
            view = inflater.inflate(R.layout.item_layout_country, null);
            // set refs for controls
            itemControlsHolder = new ControlHolder();
            itemControlsHolder.imageViewFlag = view.findViewById(R.id.imageViewFlag);
            itemControlsHolder.textViewName = view.findViewById(R.id.textViewNationName);
            itemControlsHolder.textViewPopulation = view.findViewById(R.id.textViewNationPopulation);
            //
            view.setTag(itemControlsHolder);

        } else {
            itemControlsHolder = (ControlHolder) view.getTag();
        }
        // set Data for controls which hold in itemControlsHolder
        // data
        Country nationI = dsQuocGia.get(i);
        itemControlsHolder.textViewName.setText(nationI.getCountryName());
        itemControlsHolder.textViewPopulation.setText("Population" + nationI.getPopulation());
        // image
        int resImageId = context.getResources().getIdentifier(
                nationI.getCountryFlag(),
                "mipmap",
                context.getPackageName()
        );
        itemControlsHolder.imageViewFlag.setImageResource(resImageId);
        return view;
    }
}
