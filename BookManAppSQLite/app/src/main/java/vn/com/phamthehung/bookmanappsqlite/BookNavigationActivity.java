package vn.com.phamthehung.bookmanappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BookNavigationActivity extends AppCompatActivity {
    SQLiteDatabase dbSACH;
    Cursor conTroBanGhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_navigation);
        // Mở Database
        dbSACH = openOrCreateDatabase("QuanLySach.db", MODE_PRIVATE, null);
        // Đọc toàn bộ bảng Book
        conTroBanGhi = dbSACH.rawQuery("Select * from BOOKS", null);
        // Chuyển con trỏ về bản ghi đầu tiên
        conTroBanGhi.moveToFirst();
        // Hiển thị bản ghi lên màn hình
        capNhatManHinhTheoConTro();

        Button btnNext = findViewById(R.id.btnTiepTheo);
        Button btnFirst = findViewById(R.id.btnDauTien);

        btnNext.setOnClickListener(xuLyNext);
        btnFirst.setOnClickListener(xuLyFirst);

    }//het Create
    public void capNhatManHinhTheoConTro() {
        // lấy dữ liệu ở dòng hiện tại đang được trỏ bới conTroBanGhi
        int maSach = conTroBanGhi.getInt(0);
        String tenSach = conTroBanGhi.getString(1);
        int soTrang = conTroBanGhi.getInt(2);
        float gia = conTroBanGhi.getFloat(3);
        String moTa = conTroBanGhi.getString(4);
        // đặt tên các điều khiển
        EditText edMaSach = findViewById(R.id.edMaSach);
        EditText edTenSach = findViewById(R.id.edtTenSach);
        EditText edGiaSach = findViewById(R.id.edGiaSach);
        EditText edSoTrang = findViewById(R.id.editSoTrang);
        edMaSach.setText(String.valueOf(maSach));
        edTenSach.setText(tenSach);
        edGiaSach.setText(String.valueOf(gia));
        edSoTrang.setText(String.valueOf(soTrang));
    }
    //======================================================
    View.OnClickListener xuLyNext = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!conTroBanGhi.isLast()) {
                conTroBanGhi.moveToNext();
                // Lấy dữ liệu và cập nhật lên màn hình
                capNhatManHinhTheoConTro();
            }
        }
    };

    View.OnClickListener xuLyFirst = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!conTroBanGhi.isLast()) {
                conTroBanGhi.moveToNext();
                // Lấy dữ liệu và cập nhật lên màn hình
                capNhatManHinhTheoConTro();
            }
        }
    };
}