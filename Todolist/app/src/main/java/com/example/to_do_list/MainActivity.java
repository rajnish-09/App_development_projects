package com.example.to_do_list;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    MaterialButton createButton;
    ArrayList<Task> displayTask = CreateTaskActivity.tasks;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        createButton = findViewById(R.id.addButton);

        createButton.setOnClickListener(e->{
            intent = new Intent(this, CreateTaskActivity.class);
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ToDoListAdapter ad = new ToDoListAdapter(displayTask);
        recyclerView.setAdapter(ad);
    }

    @Override
    public void onResume(){
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();;
    }
}