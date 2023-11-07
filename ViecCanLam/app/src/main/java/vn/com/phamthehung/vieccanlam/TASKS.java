package vn.com.phamthehung.vieccanlam;

import java.io.Serializable;
import java.util.HashMap;

public class TASKS implements Serializable {
    String name;
    String date;
    String message;
    String priority;

    public TASKS() {
    }

    public TASKS(String name, String date, String message, String priority) {
        this.name = name;
        this.date = date;
        this.message = message;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    //
    public HashMap<String, String> toFireBaseObject() {
        // Tạo đối tượng 'HashMap<String, String>'
        HashMap<String, String> taskObject = new HashMap<String, String>();
        // Thêm các cặp key-value vào 'taskObject'
        // Example: key: "name"
        //          value: name
        taskObject.put("name", name);
        taskObject.put("date", date);
        taskObject.put("message", message);
        taskObject.put("priority", priority);
        // Trả về 'taskObject' chứa các thông tin đc đặt trong đó dưới dạng một 'HashMap<String, String>' -> Lưu trữ/ tương tác vs dữ liệu trong R.D
        return taskObject;
    }
}
