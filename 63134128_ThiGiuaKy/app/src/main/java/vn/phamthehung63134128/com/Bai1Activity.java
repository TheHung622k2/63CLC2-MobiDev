package vn.phamthehung63134128.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Bai1Activity extends AppCompatActivity {
    EditText dkHeight, dkWeight;
    TextView dkKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        findControls();
    }

    void findControls() {
        dkHeight = findViewById(R.id.edtHeight);
        dkWeight = findViewById(R.id.edtWeight);
        dkKetQua = findViewById(R.id.tvKetQua);
    }

    public void Tinh_BMI(View v) {
        float height = Float.parseFloat(dkHeight.getText().toString());
        float weight = Float.parseFloat(dkWeight.getText().toString());

        height /= 100;

        float bmi = weight / (height * height);

        DecimalFormat df = new DecimalFormat("#.00");

        dkKetQua.setText(String.valueOf(df.format(bmi)));
    }
}