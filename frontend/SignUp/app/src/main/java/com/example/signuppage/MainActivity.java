package com.example.signuppage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button singUp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singUp = (Button)findViewById(R.id.button);

        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                signUpAttempt();
            }
        });
    }

    public void signUpAttempt()
    {
        EditText username = (EditText)findViewById(R.id.username);
        EditText email = (EditText)findViewById(R.id.email);
        EditText password = (EditText)findViewById(R.id.password);
        EditText confirmed = (EditText)findViewById(R.id.confirmedPassword);
        if(confirmed == password)
        {
            Toast.makeText(MainActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
    }
}