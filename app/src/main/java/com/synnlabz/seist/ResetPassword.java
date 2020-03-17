package com.synnlabz.seist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;

    private FirebaseAuth firebaseAuth;

    RelativeLayout rellay1, rellay2;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 1500); //1500 is the timeout for the splash

        passwordEmail = (EditText)findViewById(R.id.reset_email);
        resetPassword = (Button)findViewById(R.id.btn_reset);
        firebaseAuth = FirebaseAuth.getInstance();

        passwordEmail.setHintTextColor(Color.GRAY);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.email, android.util.Patterns.EMAIL_ADDRESS, R.string.error_email);

        final LoadingDialog loadingDialog = new LoadingDialog(ResetPassword.this);

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email = passwordEmail.getText().toString().trim();

                if (user_email.equals("")){
                    Toast.makeText(ResetPassword.this, "Please enter your email address here",Toast.LENGTH_SHORT).show();
                }else{
                    loadingDialog.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingDialog.dismissDialog();
                        }
                    },3000);
                    firebaseAuth.sendPasswordResetEmail(user_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ResetPassword.this,"Password Reset email sent!!",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ResetPassword.this,LoginActivity.class));
                            }else {
                                Toast.makeText(ResetPassword.this,"Error Sending Password Reset",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void OpenRegister(View view) {
        startActivity(new Intent(ResetPassword.this,RegistrationActivity.class));
    }

    public void OpenLogin(View view) {
        startActivity(new Intent(ResetPassword.this,LoginActivity.class));
    }
}
