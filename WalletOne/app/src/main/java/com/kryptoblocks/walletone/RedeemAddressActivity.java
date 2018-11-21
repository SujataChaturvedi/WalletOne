package com.kryptoblocks.walletone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;

//import com.google.zxing.integration.android.IntentIntegrator;

public class RedeemAddressActivity extends AppCompatActivity { //implements View.OnClickListener {
    String qrn;
Button proceed_pay;
    EditText et_address,et_amount,et_description;
    IntentIntegrator qrScan;
    ImageView img_scan;
    Toolbar toolbar;
    String QRname;


    /*public final IntentIntegrator setCaptureLayout(int resourceId) {
        addExtra("ZXING_CAPTURE_LAYOUT_ID_KEY", resourceId);
        return this;
    }
*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_address);

        et_amount = (EditText) findViewById(R.id.edittext_sendamount);
        et_address = findViewById(R.id.frnds_address);
        et_description = (EditText) findViewById(R.id.edittext_description);
        proceed_pay = (Button) findViewById(R.id.Proceed_toPay);
       // et_address = (EditText) findViewById(R.id.frnds_address);
       // img_scan = (ImageView) findViewById(R.id.img_view_scan);

        initToolBar();

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white_18dp);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(RedeemAddressActivity.this, MainActivity.class);
                         startActivity(i);
                    }
                }
        );
////////for scanner
     //   qrScan = new IntentIntegrator(this);
       // img_scan.setOnClickListener(this);


        proceed_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(RedeemAddressActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm payment");

                // Setting Dialog Message
                alertDialog.setMessage("UserName");
                // alertDialog.setMessage("amt");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Write your code here to invoke YES event
                        Toast.makeText(getApplicationContext(), "Fund Transfered", Toast.LENGTH_SHORT).show();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        //  Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
               //condition check
                if(et_address.length()==0)  {
                    Toast.makeText(getApplicationContext(), "Address can't be empty", Toast.LENGTH_SHORT).show();
                }
               else if(et_amount.length()==0){
                    Toast.makeText(getApplicationContext(), "Amount can't be empty", Toast.LENGTH_SHORT).show();

                }
                else {
                    // Showing Alert Message
                    alertDialog.show();
                }
            }
        });

    }

    //for scanner
       /* @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result != null) {
                //if qrcode has nothing in it
                if (result.getContents() == null) {
                    Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
                } else {
                    //if qr contains data
                    try {
                        //converting the data to json
                        JSONObject obj = new JSONObject(result.getContents());

                       // QRname = obj.getString("name");
                        //setting values to textviews
                      //  textViewName.setText(obj.getString("name"));
                        String s = data.getStringExtra("address");
                      //  et_address.setText(data.getString("address"));
                        et_address.setText(s);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        //if control comes here
                        //that means the encoded format not matches
                        //in this case you can display whatever data is available on the qrcode
                        //to a toast
                        et_address.setText(result.getContents());
                        //Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }*/

        //@Override for scanner
   /* public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();
    }
*/

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_Send);
        toolbar.setTitle(R.string.toolbarSend);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);
    }
    }


