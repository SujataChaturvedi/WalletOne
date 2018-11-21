package com.kryptoblocks.walletone;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import static com.facebook.FacebookSdk.getApplicationContext;

public class ReceiveActivity extends AppCompatActivity implements  View.OnClickListener{

    private static final int ACTIVITY_RESULT_QR_DRDROID = 0;

    FloatingActionButton FAB1, FAB2, FAB3,fab1,fab2,fab3,fab;
    Toolbar toolbar;
    TextView tv_add, tv_name;
   EditText amount_edittext;
    Button btn,generate_btn;
    String text2Qr,bit_img, text = "Kryptoblocks",amt;
    ImageView img;
    Bitmap img_bitmap;
    Boolean isFABOpen=false;

    //Button button;

    private IntentIntegrator qrScan;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        //getSupportActionBar().hide();

        img = (ImageView) findViewById(R.id.qr_img_view);

        /////////qr trial

        text2Qr = text.toString().trim();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE, 500, 500);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            img.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
/////////////////////
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        //FAB3 = (FloatingActionButton) findViewById(R.id.fab3);

        amount_edittext = (EditText) findViewById(R.id.receive_amount_textview);
        amt = amount_edittext.getText().toString();

      //  btn = (Button) findViewById(R.id.btn_click);
        tv_add = (TextView) findViewById(R.id.address_tv);
        generate_btn = (Button) findViewById(R.id.btn_generate);

        generate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(amount_edittext.length()==0) {
                    Toast.makeText(getApplicationContext(), "Field left empty", Toast.LENGTH_SHORT).show();
                }

                /*else if (amount_edittext.equals(0)) {
                    Toast.makeText(getApplicationContext(), "Amount cant", Toast.LENGTH_SHORT).show();
                }*/
                else {

                    //final AlertDialog.Builder builder_main = new AlertDialog.Builder(getContext());
                    final AlertDialog.Builder builder_send_request = new AlertDialog.Builder(ReceiveActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(getApplicationContext());

                    View alertView = inflater.inflate(R.layout.activity_payment__receive_, null);

                    ImageButton close_send_request = alertView.findViewById(R.id.close_image_button_payment);

                    //builder.setMessage("Create a wallet");
                    builder_send_request.setView(alertView);

                    builder_send_request.show();

                    close_send_request.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           //builder_send_request.

                        }
                    });



                   /*Intent i = new Intent(ReceiveActivity.this,Payment_Receive_Activity.class);
                    i.putExtra("amts",amount_edittext.getText().toString());
                    startActivity(i);*/

                }
            }
        });

        tv_add.setText(text);

        //qrScan = new IntentIntegrator(this);


        //button = (Button) view.findViewById(R.id.btn);

        final ClipboardManager clipboard = (ClipboardManager) getApplication().getSystemService(CLIPBOARD_SERVICE);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getstring = tv_add.getText().toString();
                ClipData myClip = ClipData.newPlainText("text", getstring);
                clipboard.setPrimaryClip(myClip);

                Snackbar.make(view, "Address copied", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });
       /* fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Print", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });*/
       fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("message/rfc822");
                startActivity(emailIntent.createChooser(emailIntent, "Share via"));
              //  Snackbar.make(view, "Share via", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });



       // fab3 = (FloatingActionButton) findViewById(R.id.fab3);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fab1.setVisibility(View.VISIBLE);
               // fab2.setVisibility(View.VISIBLE);


                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });

        //for toolbar

        initToolBar();
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white_18dp);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(ReceiveActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {
        if(!isFABOpen){
            super.onBackPressed();
        }else{
            closeFABMenu();
        }
    }
    private void showFABMenu(){
        isFABOpen=true;
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
//        fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        //fab3.animate().translationY(0);
    }


    @Override
    public void onClick(View v) {

        if(!isFABOpen){
            showFABMenu();
        }else{
            closeFABMenu();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_Receive);
        toolbar.setTitle(R.string.toolbarReceive);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);
    }
}
