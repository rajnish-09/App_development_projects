package com.example.kurakani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {
    TextView name, gmail, number, password, reTypePassword, login_link;
    Button register;
    Intent intent;

    RadioGroup group;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = findViewById(R.id.name);
        gmail = findViewById(R.id.gmail);
        number = findViewById(R.id.number);
        password = findViewById(R.id.password);
        reTypePassword = findViewById(R.id.retype_password);
        login_link = findViewById(R.id.login_link);
        register = findViewById(R.id.register);
        group = findViewById(R.id.group);

        register.setOnClickListener(v->{
            String nameInput = name.getText().toString();
            String gmailInput = gmail.getText().toString();
            String numberInput = number.getText().toString();
            String passwordInput = password.getText().toString();

            //getting selected radio button
            int selectedId = group.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedText = selectedRadioButton.getText().toString();

            DbHelper myDB = new DbHelper(RegistrationActivity.this);
            myDB.registerPeople(nameInput, gmailInput, numberInput, passwordInput, selectedText);
        });

        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}