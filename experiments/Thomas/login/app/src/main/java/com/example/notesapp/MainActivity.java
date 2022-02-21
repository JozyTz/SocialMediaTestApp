package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbutton = (MaterialButton) findViewById(R.id.loginbutton);
        MaterialButton signUp = (MaterialButton) findViewById(R.id.loginbutton3);

        //admin and admin

        loginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("demo") && password.getText().toString().equals("david")){
                    //correct
                    Toast.makeText(MainActivity.this, "Login Successful!!", Toast.LENGTH_SHORT).show();
                    openSecondPage();
                } else
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

            }
        });
        signUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sign Up Here", Toast.LENGTH_SHORT).show();
                openSignUpPage();
            }
        });

    }

    public void openSecondPage() {
        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }

    public void openSignUpPage() {
        Intent signUp = new Intent(this, SignUpPage.class);
        startActivity(signUp);
    }
}