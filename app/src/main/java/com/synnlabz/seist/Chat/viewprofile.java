package com.synnlabz.seist.Chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.synnlabz.seist.R;

public class viewprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);
    }

    public void backToChat(View view) {
        Intent intent = new Intent(viewprofile.this, ChatActivity.class);
        startActivity(intent);
        return;
    }
}
