package vn.com.phamthehung.vieccanlam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TASKS> lstVCL;
    TaskRVadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tạo kết nối đến CSDL Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // Lấy một tham chiếu đến node gốc trên CSDL Firebase
        // Node gốc là điểm khởi đầu để truy cập + lưu trữ data
        DatabaseReference databaseReference = database.getReference("TASKS"); // Node gốc "TASKS"

        // Lắng nghe và xủ lý sk
        // Tạo một ArrayList dùng để lưu data từ CSDL sau khi nó được truy vấn
        lstVCL = new ArrayList<TASKS>();
        // Thêm sự kiện lắng nghe vào 'databaseReference'
        // Sự kiện này là một 'ValueEventListener': đc sử dụng để lắng nghe sự thay đổi dữ liệu tại Node gốc
        databaseReference.addValueEventListener(ngheFB);

        // Tìm điều khiển
        RecyclerView recyclerView = findViewById(R.id.rcvVCL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new TaskRVadapter(lstVCL);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    ValueEventListener ngheFB = new ValueEventListener() {
        // 'OnDataChange(@NonNull DataSnapshot snapshot)': Xử lý khi có sự thay đổi dữ liệu trong Node 'TASKS'
        // Mỗi khi có d/liệu mới đc thêm or thay đổi, p/thức này sẽ đc gọi.
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            // Duyệt qua tất cả các con của 'snapshot', mỗi con là một dữ liệu trong Node 'TASKS' (Hashmap Object), chứa thông tin về một công việc cần làm
            for (DataSnapshot obj : snapshot.getChildren()) {
                TASKS task = obj.getValue(TASKS.class); // Trích xuất dữ liệu từ 'obj' và chuyển đổi nó thành một đối tượng 'TASKS' bằng phương thức 'getValue' và truyền vào lớp đối tượng 'TASKS' -> Dữ liệu trên CSDL tương thích với cấu trúc của lớp 'TASKS'
                lstVCL.add(task); // Sau khi có đối tượng 'task' từ CSDL, ta thêm nó vào danh sách -> Ta lưu danh sách các công việc cần làm từ CSDL trong 'lstVCL'
                // In ra thông tin về việc cần làm từ đối tượng 'task'
                Log.w("VCL app", "Tên việc cần làm: " + task.getName());
            }
            adapter.notifyDataSetChanged();
        }

        // Xử lý khi có lỗi xảy ra trong quá trình truy xuất dữ liệu
        @Override
        public void onCancelled(@NonNull DatabaseError error) {
        }
    };
}