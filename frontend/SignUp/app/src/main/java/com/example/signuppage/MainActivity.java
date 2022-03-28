package com.example.signuppage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{
    Button singUp;
    //Server server;
    private com.android.volley.toolbox.Volley Volley;

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
                try {
                    signUpAttempt();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void signUpAttempt() throws JSONException {
        EditText username = (EditText)findViewById(R.id.username);
        EditText email = (EditText)findViewById(R.id.email);
        EditText password = (EditText)findViewById(R.id.password);
        EditText confirmed = (EditText)findViewById(R.id.confirmedPassword);
        String url = "http://coms-309-025.class.las.iastate.edu:8080/users/create/";

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();

        if(password.getText().toString().equals(confirmed.getText().toString()) && password.getText().toString().length() >= 5)
        {
            Toast.makeText(MainActivity.this, "Passwords match!", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
    }
}