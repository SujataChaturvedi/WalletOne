package com.kryptoblocks.walletone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.json.JSONException;
import org.json.JSONObject;

//import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SendActivity extends AppCompatActivity implements OnClickListener {
    Button msend, psend;
    ImageView img;
    TextView textViewName,textViewAddress;
    LinearLayout layout,parent_layout;
    TextView address_gift,scan_tv;
    IntentIntegrator qrScan;
    String QRname;
    SurfaceView surf_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        // msend = (Button) findViewById(R.id.send_button);
       // psend = (Button) findViewById(R.id.ok_send_btn);
       // layout = (LinearLayout) findViewById(R.id.linerlay);
       // parent_layout = (LinearLayout) findViewById(R.id.parent_lin_lay);
       // address_gift = (TextView) findViewById(R.id.gift_address_textview);
       // textViewAddress = (TextView) findViewById(R.id.trial_address);
        //surf_view = (SurfaceView) findViewById(R.id.camera_view);
       // scan_tv = (TextView) findViewById(R.id.scan_textview);
        qrScan = new IntentIntegrator(this);

        //qrScan.se(R.id.scan_frame);

       // img = (ImageView) findViewById(R.id.qr_img_view);

//        scan_tv.setOnClickListener(this);

       /* address_gift.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SendActivity.this, RedeemAddressActivity.class);
                i.putExtra("nameQR", QRname);
                startActivity(i);
            }
        });*/




       /* msend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setVisibility(View.VISIBLE);
                parent_layout.setVisibility(View.GONE);


                psend.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        layout.setVisibility(View.GONE);
                        parent_layout.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplication(), "Funds Sent", Toast.LENGTH_SHORT).show();
                    }
                });


                msend.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        layout.setVisibility(View.VISIBLE);
                        parent_layout.setVisibility(View.GONE);


                    }
                });


            }
        });
    }*/
    }
        @Override
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

                         QRname = obj.getString("name");
                        //setting values to textviews
                   // textViewName.setText(obj.getString("name"));
                      //  textViewAddress.setText(obj.getString("address"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        //if control comes here
                        //that means the encoded format not matches
                        //in this case you can display whatever data is available on the qrcode
                        //to a toast
                        Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
        //@Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();
    }
    }



