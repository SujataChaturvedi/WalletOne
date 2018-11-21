package com.kryptoblocks.walletone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Payment_Receive_Activity extends AppCompatActivity {

    TextView amount_receive;
    String receiving_amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__receive_);

        amount_receive = (TextView) findViewById(R.id.receive_amt);
       // amount_receive.setText(getIntent().getStringExtra("amts"));
        Intent i = getIntent();
        //Bundle bun = i.getExtras();
       // if (bun != null) {
            receiving_amt = i.getExtras().getString("amts");
            amount_receive.setText(receiving_amt);


    }
    }
//}