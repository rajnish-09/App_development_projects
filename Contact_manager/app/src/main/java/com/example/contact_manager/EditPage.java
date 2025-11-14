package com.example.contact_manager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditPage extends AppCompatActivity {
    EditText editName, editPhone, edit_name, edit_phone;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        editName = findViewById(R.id.edit_name);
        editPhone = findViewById(R.id.edit_phone);
        save = findViewById(R.id.save_btn);

//        edit_name = findViewById(R.id.edit_name);
//        edit_phone = findViewById(R.id.edit_phone);

        Intent intent = getIntent();
        String name = intent.getStringExtra("EXTRA_NAME");
        String phone = intent.getStringExtra("EXTRA_PHONE");
        int index = Integer.parseInt(intent.getStringExtra("INDEX"));
        editName.setText(name);
        editPhone.setText(phone);

        save.setOnClickListener(v->{
            String newName = editName.getText().toString();
            String newPhone = editPhone.getText().toString();
            MainActivity.cName.get(index).setName(newName);
            MainActivity.cName.get(index).setPhone(newPhone);
            finish();
        });

    }
}