package com.example.combined;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;


public class ProfileActivity extends Activity implements OnClickListener {

    ListView listView;
    String[] songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView profile = (TextView) findViewById(R.id.profile);

        listView = findViewById(R.id.profileSongList);
        runtimePermission();

        profile.setText(LoginActivity.getUsername());




        Button followButton = (Button) findViewById(R.id.follow);
        followButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //openProfilePage();
                //do the follow tings here

            }
        });


    }

    public void runtimePermission(){
        Dexter.withContext(this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                displaySongs();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    public ArrayList<File> findSong (File file){
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();

        try{
            for (File singlefile : files){
                if (singlefile.isDirectory() && !singlefile.isHidden()){
                    arrayList.addAll(findSong(singlefile));
                }
                else {
                    if (singlefile.getName().endsWith(".mp3") || singlefile.getName().endsWith(".mp4")){
                        arrayList.add(singlefile);
                    }
                }
            }
        } catch(NullPointerException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
        }
        return arrayList;
    }

    void displaySongs(){
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());

        songs = new String[mySongs.size()];
        for (int i = 0; i < mySongs.size(); i++){
            songs[i] = mySongs.get(i).getName().toString().replace(".mp3", "").replace(".mp4", "");

        }
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songs);
        listView.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View view) {

    }
}



