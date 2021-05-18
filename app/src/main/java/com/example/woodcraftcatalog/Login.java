package com.example.woodcraftcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btnlog;
    TextView btnsign;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        btnlog = findViewById(R.id.btnlog);
        btnsign = findViewById(R.id.signup);
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, signup.class);
                startActivity(registerIntent);
            }
        });

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });
    }
    private void checkCredentials() {
        String user=username.getText().toString();
        String pass=password.getText().toString();


        if (user.isEmpty())
        {
            showError(username, "your username is not valid!");
        }
        else if (pass.isEmpty())
        {
            showError(password,"Password must be 7 characters");
        }
        else
        {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            Toast.makeText(this, "Login Succesfully",Toast.LENGTH_SHORT).show();
        }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}