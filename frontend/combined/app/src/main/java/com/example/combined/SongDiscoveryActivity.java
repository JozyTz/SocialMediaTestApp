package com.example.combined;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;


public class SongDiscoveryActivity extends AppCompatActivity implements OnClickListener {

    ListView listView;
    String[] songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_discovery_page);
        listView = findViewById(R.id.discoveryPageSongList);
        runtimePermission();


        Toolbar myToolbar = (Toolbar) findViewById(R.id.banner);
        setSupportActionBar(myToolbar);

        TextView testbutton = (TextView) findViewById(R.id.testbutton);

        //These are the navigation menu button instatiations
        MenuItem profilebutton = (MenuItem) findViewById(R.id.action_profile);
        MenuItem createnewsongbutton = (MenuItem) findViewById(R.id.action_create_new_song);
        testbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openComment();
//                testbutton.setText(" FUCK " + com.example.combined.LoginActivity.getUsername());

            }
        });

    }



    @Override
    public void onClick (View view){

    }

    //});

    //Instantiate the navigation menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_page_navigation,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_profile:
                //bring up profile page
                profilePage();
            case R.id.action_create_new_song:
                //bring up create new song page
                createNewSongPage();
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }

    //creates the profile page when the button is pressed
    public void profilePage() {
        Intent intent = new Intent( this, com.example.combined.ProfileActivity.class);
        startActivity(intent);
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

    //creates the new song activity page, but that doesn't exist yet
    public void createNewSongPage() {
        Intent intent = new Intent(this, songActivity.class);
        startActivity(intent);
    }
    public void openComment() {
        Intent intent = new Intent(this, CommentActivity.class);
        startActivity(intent);
    }


}

