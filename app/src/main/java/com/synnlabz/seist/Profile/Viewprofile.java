package com.synnlabz.seist.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.synnlabz.seist.MainActivity;
import com.synnlabz.seist.Matches.MatchesActivity;
import com.synnlabz.seist.R;

import java.util.Map;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class Viewprofile extends AppCompatActivity {

    private TextView mFacultyField , mBioField , mAgeField , mIntakeField , mNameField , mDegreeField;

    private ImageView mProfileImage;

    private FirebaseAuth mAuth;
    private DatabaseReference mUserDatabase;

    private String userId, matchId, name, profileImageUrl , faculty , bio , age , intake ,degree , userSex;

    private Uri resultUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        matchId = getIntent().getExtras().getString("matchId");
        PulsatorLayout pulsator = (PulsatorLayout) findViewById(R.id.pulsator);
        pulsator.start();

        mNameField = (TextView) findViewById(R.id.name);
        mFacultyField = (TextView) findViewById(R.id.faculty);
        mBioField = (TextView) findViewById(R.id.bio);
        mAgeField = (TextView) findViewById(R.id.age);
        mDegreeField = (TextView) findViewById(R.id.degree);
        mIntakeField = (TextView) findViewById(R.id.intake);
        mProfileImage = (ImageView) findViewById(R.id.profileImage);

        mAuth = FirebaseAuth.getInstance();
        userId = mAuth.getCurrentUser().getUid();

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(matchId);

        getUserInfo();
    }

    private void getUserInfo() {
        mUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists() && dataSnapshot.getChildrenCount()>0){
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    if(map.get("name")!=null){
                        name = map.get("name").toString();
                        mNameField.setText(name);
                    }
                    if(map.get("faculty")!=null){
                        faculty = map.get("faculty").toString();
                        mFacultyField.setText(faculty);
                    }
                    if(map.get("intake")!=null){
                        intake = map.get("intake").toString();
                        mIntakeField.setText(intake);
                    }
                    if(map.get("bio")!=null){
                        bio = map.get("bio").toString();
                        mBioField.setText(bio);
                    }
                    if(map.get("age")!=null){
                        age = map.get("age").toString();
                        mAgeField.setText(age);
                    }
                    if(map.get("degree")!=null){
                        degree = map.get("degree").toString();
                        mDegreeField.setText(degree);
                    }
                    if(map.get("sex")!=null){
                        userSex = map.get("sex").toString();
                    }
                    Glide.clear(mProfileImage);
                    if(map.get("profileImageUrl")!=null){
                        profileImageUrl = map.get("profileImageUrl").toString();
                        switch(profileImageUrl){
                            case "default":
                                Glide.with(getApplication()).load(R.mipmap.ic_launcher).into(mProfileImage);
                                break;
                            default:
                                Glide.with(getApplication()).load(profileImageUrl).into(mProfileImage);
                                break;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            final Uri imageUri = data.getData();
            resultUri = imageUri;
            mProfileImage.setImageURI(resultUri);
        }
    }

    public void BackButton(View view) {
        finish();
    }

}
