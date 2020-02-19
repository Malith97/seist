package com.synnlabz.seist.Chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.synnlabz.seist.MainActivity;
import com.synnlabz.seist.Matches.MatchesActivity;
import com.synnlabz.seist.R;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class Viewprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        PulsatorLayout pulsator = (PulsatorLayout) findViewById(R.id.pulsator);
        pulsator.start();

    }

    public void BackButton(View view) {
        finish();
    }

}
