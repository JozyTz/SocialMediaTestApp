package com.example.combined;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class songActivity extends AppCompatActivity
{
    TextView songTitle;
    Button picture;
    Button username;
    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songpage);

        songTitle = (TextView)findViewById(R.id.songTitle);
        username = (Button)findViewById(R.id.username);
        picture = (Button)findViewById(R.id.profilePicture);
        playButton = (Button)findViewById(R.id.playButton);

        username.setText(LoginActivity.getUsername());
//        songTitle.setText(((globalVariables) this.getApplication()).getTitle());

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                linkToProfile();
            }
        });
        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                linkToProfile();
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                playSong();
            }
        });
    }

    public void linkToProfile()
    {
        Toast.makeText(songActivity.this, "Links to the profile page.", Toast.LENGTH_SHORT).show();
    }

    public void playSong()
    {
        Toast.makeText(songActivity.this, "Plays the song.", Toast.LENGTH_SHORT).show();
    }
}
