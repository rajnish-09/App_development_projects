package com.example.contact_manager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView edit, delete;
    public static ArrayList<Contact> cName = new ArrayList<>();
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit);
        delete = findViewById(R.id.delete);

        String[] contacts_name = getResources().getStringArray(R.array.contacts_name);
        String[] contacts_phone = getResources().getStringArray(R.array.contacts_phone);

        recyclerView = findViewById(R.id.recyclerView);
        for(int i = 0; i<contacts_name.length; i++){
            cName.add(new Contact(contacts_name[i],contacts_phone[i]));
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ContactAdapter cad = new ContactAdapter(cName);
        recyclerView.setAdapter(cad);




    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged(); // refresh RecyclerView
    }

}