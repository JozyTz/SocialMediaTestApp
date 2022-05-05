package com.example.combined;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CommentActivity extends AppCompatActivity {

    private WebSocketClient cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);


        TextView post = (TextView) findViewById(R.id.post3);
        EditText commentBox = (EditText) findViewById(R.id.postComment);
        Button postCommentButton = (Button) findViewById(R.id.postCommentButton);


        postCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post.setText(commentBox.getText().toString());

            }
        });

    }
}
