package com.kryptoblocks.walletone.verification.success;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kryptoblocks.walletone.LoginActivity;
import com.kryptoblocks.walletone.MainActivity;
import com.kryptoblocks.walletone.R;
import com.kryptoblocks.walletone.Splash;

public class VerificationSuccessfulActivity extends AppCompatActivity {

    ConstraintLayout layout;

    public static Intent getIntent(Context context) {
        return new Intent(context, VerificationSuccessfulActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_successful);

        layout = findViewById(R.id.try_layout);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(VerificationSuccessfulActivity.this,MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 2500);
    }
/*
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VerificationSuccessfulActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }*/
}
