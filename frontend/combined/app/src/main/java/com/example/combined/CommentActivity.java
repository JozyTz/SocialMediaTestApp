package com.example.combined;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CommentActivity extends AppCompatActivity {

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
