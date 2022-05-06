package com.example.combined;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity
{
    Button signUp;
    private com.android.volley.toolbox.Volley Volley;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUp = (Button)findViewById(R.id.button);

        signUp.setOnClickListener(new View.OnClickListener() {
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
            //Toast.makeText(MainActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
            try {
                //input your API parameters
                object.put("username","tglass");
                object.put("password","glass");
                object.put("email","tglass@gmail.com");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Toast.makeText(getApplicationContext(), "Worked", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(jsonObjectRequest);
        }else
        {
            Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
    }


    public static boolean EmailValidation(CharSequence email){

        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
}