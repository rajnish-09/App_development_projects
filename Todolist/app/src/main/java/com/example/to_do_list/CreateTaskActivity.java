package com.example.to_do_list;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CreateTaskActivity extends AppCompatActivity {
    EditText taskTitle, taskDescription;
    Button saveTask;

    public static ArrayList<Task> tasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        taskTitle = findViewById(R.id.task_title);
        taskDescription = findViewById(R.id.task_description);
        saveTask = findViewById(R.id.save_btn);

        saveTask.setOnClickListener(v -> {
            String title = taskTitle.getText().toString();
            String description = taskDescription.getText().toString();
            if(title == null){
                taskTitle.setError("Title required.");
                return;
            }
            Task newTask = new Task(title, description);
            tasks.add(newTask);
            finish();
        });
    }
}