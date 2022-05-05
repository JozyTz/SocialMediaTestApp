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
import org.w3c.dom.Text;

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
    TextView e1;
    EditText commentBox;
    Button postCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

         e1 = (TextView) findViewById(R.id.et1);
         commentBox = (EditText) findViewById(R.id.postComment);
         postCommentButton = (Button) findViewById(R.id.postCommentButton);


//        postCommentButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                Draft[] drafts = {
                        new Draft_6455()
                };
                String w = "ws://10.0.2.2:8080/websocket/" + LoginActivity.getUsername();

                try {
                    Log.d("Socket:", "Trying socket");
                    cc = new WebSocketClient(new URI(w), (Draft) drafts[0]) {
                        @Override
                        public void onMessage(String message) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String s = postCommentButton.getText().toString();
                                    e1.setText(s + " " + message);
                                }
                            });
                            Log.d("", "run() returned: " + message);

                        }
                        @Override
                        public void onOpen(ServerHandshake handshake) {
                            Log.d("OPEN", "run() returned: " + "is connecting");
                        }

                        @Override
                        public void onClose(int code, String reason, boolean remote) {
                            Log.d("CLOSE", "onClose() returned: " + reason);
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d("Exception:", e.toString());
                        }
                    };
                } catch (URISyntaxException e) {
                    Log.d("Exception:", e.getMessage().toString());
                    e.printStackTrace();
                }
                cc.connect();

//            }
//        });

        postCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cc.send(commentBox.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
//          Log.d("ExceptionSendMessage:", e.getMessage());
                }
            }
        });
    }

}
