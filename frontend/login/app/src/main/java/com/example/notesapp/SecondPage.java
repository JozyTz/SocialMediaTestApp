package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.view.View;
import android.view.View.OnClickListener;


import com.google.android.material.button.MaterialButton;



//kyle
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
//end kyle


public class SecondPage extends Activity implements OnClickListener {
    private Button btnJson, btnString, btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        TextView loggedin = (TextView) findViewById(R.id.loggedin);
        EditText inputText = (EditText) findViewById(R.id.inputText);

        MaterialButton namebutton = (MaterialButton) findViewById(R.id.namebutton);


        btnString = (Button) findViewById(R.id.btnStringRequest);
        btnJson = (Button) findViewById(R.id.btnJsonRequest);
        btnImage = (Button) findViewById(R.id.btnImageRequest);

        // button click listeners
        btnString.setOnClickListener(this);
        btnJson.setOnClickListener(this);
        btnImage.setOnClickListener(this);

        //kyle
//        Spinner spinnerLanguages=findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spinnerLanguages.setAdapter(adapter);

        //end kyle
    }
        //namebutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //loggedin.setText("Hi " + inputText.getText());
                System.out.println("Button clicked");

                switch (view.getId()) {
                    case R.id.btnStringRequest:
                        startActivity(new Intent(SecondPage.this,
                                StringRequestActivity.class));
                        break;
                    case R.id.btnJsonRequest:
                        startActivity(new Intent(SecondPage.this,
                                JsonRequestActivity.class));
                        break;
                    case R.id.btnImageRequest:
                        startActivity(new Intent(SecondPage.this,
                                ImageRequestActivity.class));
                        break;
                    default:
                        break;
                }
            }

            //});

}