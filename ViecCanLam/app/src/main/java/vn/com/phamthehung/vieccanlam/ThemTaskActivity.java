package vn.com.phamthehung.vieccanlam;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ThemTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_task);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu
                EditText editTextName = findViewById(R.id.editTextTenCV);
                EditText editTextMess = findViewById(R.id.editTextMesage);
                EditText editTextDate = findViewById(R.id.editTextDate);
                EditText editTextPrio = findViewById(R.id.editTextPrio);

                String tenCV = editTextName.getText().toString();
                String mess = editTextMess.getText().toString();
                String dat = editTextDate.getText().toString();
                String pri = editTextPrio.getText().toString();

                // Gói vào đối tượng TASKS
                TASKS task = new TASKS(tenCV, dat, mess, pri);

                // Kết nối tới CSDL, và thêm
                // Tạo kết nối đến CSDL Firebase Database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                // Lấy một tham chiếu đến node gốc trên CSDL Firebase
                // Node gốc là điểm khởi đầu để truy cập + lưu trữ data
                DatabaseReference databaseReference = database.getReference("TASKS"); // Node gốc "TASKS"

                // Tọa một key
                String key = databaseReference.push().getKey();

                HashMap<String, Object> item = new HashMap<String, Object>();
                item.put(key, task.toFireBaseObject());

                databaseReference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error == null)
                            finish();
                    }
                });
            }
        });

    }
}