package com.example.combined;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class uploadActivity extends AppCompatActivity
{
    Button uploadSong;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        uploadSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                uploadNow();
            }
        });
    }

    public void uploadNow()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
