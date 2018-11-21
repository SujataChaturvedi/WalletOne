package com.kryptoblocks.walletone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kryptoblocks.walletone.verification.failure.VerificationFailedActivity;

public class RegistrationActivity extends AppCompatActivity {

    TextView tv_uname, tv_uid, tv_phnum;
    Button btn_registration;
    String username,useremail;
    String FBName, FBBirthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        tv_uname = findViewById(R.id.registration_userName);
        tv_uid = findViewById(R.id.registration_gmailId);
        tv_phnum = findViewById(R.id.registration_phoneNumber);
        btn_registration = findViewById(R.id.regsitration_button);

        //for gmail
        Intent i = getIntent();
        Bundle bun = i.getExtras();
        username = i.getExtras().getString("fullname");
        useremail = i.getExtras().getString("userEmail");
        tv_uname.setText(username);
        tv_uid.setText(useremail);

        //for facebook
        Intent fi = getIntent();
        FBName =fi.getExtras().getString("FBFullname");
        FBBirthDate = fi.getExtras().getString("FbBirth");
        tv_uname.setText(FBName);
        tv_uid.setText(FBBirthDate);



        btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegistrationActivity.this, VerificationFailedActivity.class);

                if (tv_phnum.length() == 0 ) {
                    Toast.makeText(getApplication(), "Phone number filed can't be left empty", Toast.LENGTH_SHORT).show();
                } else if(tv_phnum.length()!=10) {
                    Toast.makeText(getApplication(), "Field should have atleast 10 digits", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    startActivity(intent);
                }
            }

        });
    }
}
