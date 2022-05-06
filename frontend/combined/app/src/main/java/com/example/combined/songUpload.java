package com.example.combined;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class songUpload extends AppCompatActivity
{
    Button uploadSong;
    Button privateSong;
    Integer publicSong = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        uploadSong = (Button)findViewById(R.id.uploadSongButton);
        privateSong = (Button)findViewById(R.id.publicSong);

        uploadSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                uploadNow();
            }
        });
        privateSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                makePrivate();
            }
        });
    }

    public void uploadNow()
    {
        Toast.makeText(getApplicationContext(), "Song successfully uploaded!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SongDiscoveryActivity.class);
        startActivity(intent);
    }

    public void makePrivate()
    {
        if(publicSong == 1)
        {
            Toast.makeText(getApplicationContext(), "Song available for friends.", Toast.LENGTH_SHORT).show();
            publicSong--;
        }else
        {
            Toast.makeText(getApplicationContext(), "Song available for public.", Toast.LENGTH_SHORT).show();
            publicSong++;
        }
    }
}
