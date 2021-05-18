package com.example.woodcraftcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    DBHelper db;
    EditText email, password, repassword, phone;
    Button Register;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBHelper(this);
        email = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        repassword = findViewById(R.id.repass);
        phone = findViewById(R.id.phone);
        Register = findViewById(R.id.signup);
        login = findViewById(R.id.gotolog);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginview = new Intent(signup.this,Login.class);
                startActivity(loginview);

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkCredentials();
            }
        });

        checkCredentials();
    }

    private void checkCredentials() {
        String user=email.getText().toString();
        String pass=password.getText().toString();
        String repass=repassword.getText().toString();
        String phonenum=phone.getText().toString();

        if (user.isEmpty())
        {
            showError(email, "your username is not valid!");
        }
        else if (pass.isEmpty())
        {
            showError(password,"Password must be 7 characters");
        }
        else if (repass.isEmpty() || !repass.equals(pass))
        {
            showError(repassword, "Password not match!");
        }
        else if(phonenum.isEmpty())
        {
            showError(phone,"Insert phone number!");
        }
        else
        {
            Toast.makeText(this, "Registered Succesfully",Toast.LENGTH_SHORT).show();
        }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}