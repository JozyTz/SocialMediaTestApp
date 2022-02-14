package com.example.customlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button login;
    TextView tv;
    TextView success;
    int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.button2);
        tv = findViewById(R.id.pCounter);
        success = findViewById(R.id.textView2);
        tv.setText("" + counter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAttempt();
            }
        });
    }

    public void loginAttempt()
    {

        //TextView tv = findViewById(R.id.pCounter);
        EditText username = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText password = (EditText)findViewById(R.id.editTextTextPersonName2);
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
        {
            counter = 5;
            tv.setText("" + counter);
            success.setText("Username and password are correct!");
        }else
        {
            counter--;
            tv.setText("" + counter);
            success.setText("Username and password are wrong!");
            if(counter == 0)
            {
                login.setEnabled(false);
            }
        }
    }
}