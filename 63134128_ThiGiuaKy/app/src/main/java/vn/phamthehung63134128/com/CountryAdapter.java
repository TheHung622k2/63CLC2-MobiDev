package vn.phamthehung63134128.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {
    private ArrayList<Country> dsQuocGia;
    private Context context;
    private LayoutInflater inflater;

    // Constructor
    public CountryAdapter(ArrayList<Country> dsQuocGia, Context context) {
        this.dsQuocGia = dsQuocGia;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    class ControlHolder {
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

        ControlHolder itemControlsHolder;
        if (view == null) {
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
