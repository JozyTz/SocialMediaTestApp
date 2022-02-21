package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class SignUpPage extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        TextView loggedin = (TextView) findViewById(R.id.loggedin);
        EditText inputText = (EditText) findViewById(R.id.inputText);

        MaterialButton namebutton = (MaterialButton) findViewById(R.id.namebutton);

        namebutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                loggedin.setText("Hi " + inputText.getText());
                System.out.println("Button clicked");
            }

        });
    }
}
