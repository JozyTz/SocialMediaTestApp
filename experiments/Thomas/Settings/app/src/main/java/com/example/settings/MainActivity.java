package com.example.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button userSettings;
    Button displaySettings;
    Button deleteAccount;
    Button notificationSettings;
    Integer notifications = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displaySettings = (Button) findViewById(R.id.DisplaySettings);
        userSettings = (Button) findViewById(R.id.UserSettings);
        deleteAccount = (Button) findViewById(R.id.Delete);
        notificationSettings = (Button) findViewById(R.id.Notifications);

        userSettings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                userSettings();
            }
        });
        displaySettings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                displaySettings();
            }
        });
        deleteAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                deleteAccount();
            }
        });
        notificationSettings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                notificationSettings();
            }
        });
    }

    public void displaySettings()
    {
        Intent intent = new Intent(this, displaySettings.class);
        startActivity(intent);
    }
    public void userSettings()
    {
        Intent intent = new Intent(this, userSettings.class);
        startActivity(intent);
    }
    public void notificationSettings()
    {
        if(notifications == 1)
        {
            Toast.makeText(getApplicationContext(), "Notifications Off", Toast.LENGTH_SHORT).show();
            notifications--;
        }else
        {
            Toast.makeText(getApplicationContext(), "Notifications On", Toast.LENGTH_SHORT).show();
            notifications++;
        }
    }
    public void deleteAccount()
    {
        Toast.makeText(getApplicationContext(), "Account Deleted", Toast.LENGTH_SHORT).show();
    }
}