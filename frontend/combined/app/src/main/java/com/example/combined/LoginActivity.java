package com.example.combined;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.AppController;
import net_utils.Const;

public class LoginActivity extends AppCompatActivity {
    public static TextView username;
    public static TextView password;
    public static boolean isItOkay = true;
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";
    private ProgressDialog pDialog;
    private String TAG = LoginActivity.class.getSimpleName();
    private TextView msgResponse;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        this.username = (TextView) findViewById(R.id.username);
        this.password = (TextView) findViewById(R.id.password);
        final TextView signUpButton = (TextView) findViewById(R.id.signup);
        Button loginbutton = (Button) findViewById(R.id.loginbutton);



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openProfilePage();
                //openSignUpPage();
                openSongDiscoveryActivity();
                //openCommentPage();

            }
        });


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObjReq();
                //openSecondPage();

            }
        });

    }

    public void invalid() {
        Toast.makeText(this, "Invalid", Toast.LENGTH_LONG);
    }

    public void valid() {
        Toast.makeText(this, "Valid", Toast.LENGTH_LONG);
    }


    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openSongDiscoveryActivity() {
        Intent intent = new Intent(this, SongDiscoveryActivity.class);
        startActivity(intent);
    }

    public void openSignUpPage() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void openProfilePage() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    public void openCommentPage() {
        Intent intent = new Intent(this, CommentActivity.class);
        startActivity(intent);
    }


    public static String getUsername() {
        return (username.getText().toString());
    }

    public static String getPassword() {
        return (password.getText().toString());
    }


    public void makeJsonObjReq() {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("username", getUsername());
            object.put("password", getPassword());
        } catch (JSONException e){
            e.printStackTrace();
        }


        //showProgressDialog();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                Const.URL_JSON_OBJECT, object,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        //msgResponse.setText(response.toString());
                        //hideProgressDialog();
                        if (response.toString().contains("true")) {
                            openProfilePage();
                            SharedPreferences prefs = getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                //hideProgressDialog();
            }
        })

        {


            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Androidhive");
                params.put("email", "abc@androidhive.info");
                params.put("pass", "password123");

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq,
                tag_json_obj);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }
}