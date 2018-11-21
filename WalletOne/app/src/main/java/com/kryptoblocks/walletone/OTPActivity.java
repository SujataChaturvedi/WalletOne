package com.kryptoblocks.walletone;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
//import android.widget.Toolbar;
//import android.widget.Toolbar;

public class OTPActivity extends AppCompatActivity {

    Button otp_button;
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

       // toolbar = findViewById(R.id.toolbar_Send);


        otp_button = (Button) findViewById(R.id.button_submit_otp);

        otp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(OTPActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        initToolBar();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_OTP);
        toolbar.setTitle(R.string.toolbarOTP);
        setSupportActionBar(toolbar);
    }
}
