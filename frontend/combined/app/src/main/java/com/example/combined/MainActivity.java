package com.example.combined;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button settings;
    Button upload;
    Button futureUse;
    Button song1;
    Button song2;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = (Button) findViewById(R.id.settingsButton);
        upload = (Button) findViewById(R.id.uploadButton);
        futureUse = (Button) findViewById(R.id.futureUse);
        song1 = (Button) findViewById(R.id.song1);
        song2 = (Button) findViewById(R.id.song2);

        settings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                settingsPage();
            }
        });

        upload.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                uploadPage();
            }
        });

        song1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                title = song1.getText().toString();
                songPage();
            }
        });
        song2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                title = song2.getText().toString();
                songPage();
            }
        });
    }

    public void settingsPage()
    {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

    public void uploadPage()
    {
        Intent intent = new Intent(this, songUpload.class);
        startActivity(intent);
    }

    public void songPage()
    {
        Intent intent = new Intent(this, songActivity.class);
//        ((globalVariables) this.getApplication()).setTitle(title);
        startActivity(intent);
    }
}