package com.phamthehung.exercise_14;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControls();

        // Xử lý sự kiện khi nhấn nút "Change Font Size"
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFontSizeDialog();
            }
        });

        // Xử lý sự kiện khi nhấn nút "Change Color"
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorDialog();
            }
        });
    }

    public void findControls() {
        txt = findViewById(R.id.txt);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }

    private void showFontSizeDialog() {
        final String[] fontSizeOptions = {"20sp", "30sp", "40sp", "50sp", "60sp"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Font Size");
        builder.setItems(fontSizeOptions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Thay đổi kích thước font dựa trên lựa chọn
                String selectedSize = fontSizeOptions[which];
                int fontSize = Integer.parseInt(selectedSize.replaceAll("[^0-9]", ""));
                txt.setTextSize(fontSize);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showColorDialog() {
        final String[] colorOptions = {"Red", "Blue", "Green", "Black"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Text Color");
        builder.setItems(colorOptions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Thay đổi màu sắc font dựa trên lựa chọn
                String selectedColor = colorOptions[which];
                int color = Color.BLACK; // Màu mặc định (Black)
                if (selectedColor.equals("Red")) {
                    color = Color.RED;
                } else if (selectedColor.equals("Blue")) {
                    color = Color.BLUE;
                } else if (selectedColor.equals("Green")) {
                    color = Color.GREEN;
                }
                txt.setTextColor(color);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}