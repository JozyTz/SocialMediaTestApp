package com.example.songpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity
{
    Button username;
    TextView songTitle;
    Button picture;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (Button)findViewById(R.id.username);
        songTitle = (TextView)findViewById(R.id.songTitle);
        picture = (Button)findViewById(R.id.profilePicture);

        username.setText("Username");
        songTitle.setText("Song title here.");

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                linkToProfile();
            }
        });
    }

    public void linkToProfile()
    {
        Toast.makeText(MainActivity.this, "Links to the profile page.", Toast.LENGTH_SHORT).show();
    }
}