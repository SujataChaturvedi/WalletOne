package com.kryptoblocks.walletone.fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.kryptoblocks.walletone.adapters.Recent_Activities_Adapter;
import com.kryptoblocks.walletone.pojo.Recent_activities;
import com.kryptoblocks.walletone.R;
import com.kryptoblocks.walletone.ReceiveActivity;
import com.kryptoblocks.walletone.scanner.FullScannerActivity;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendReceiveFragment extends Fragment {

    Button btn_gift, btn_redeem;
    ImageView img;
    String text="Kryptoblocks",text2Qr;
    private RecyclerView recyclerView;
    Toolbar toolbar;
    ByteArrayOutputStream stream;
    Bitmap bit;
    Recent_Activities_Adapter recent_adapter;
    //private List<Activities_Card_List> albumList;

    private List<Recent_activities> recent_activities;
    private RecyclerView.LayoutManager layoutManager;


    public SendReceiveFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_receive, container, false);


        btn_gift = (Button) view.findViewById(R.id.gift_btn);
        btn_redeem = (Button) view.findViewById(R.id.redeem_btn);
        //img = (ImageView) view.findViewById(R.id.img_currency);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar_Main);

        recyclerView = (RecyclerView) view.findViewById(R.id.activities_recycler_view);
       // img = (ImageView) view.findViewById(R.id.img_bit);

        recent_activities = new ArrayList<>();
        recent_adapter = new Recent_Activities_Adapter(getActivity(), recent_activities);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        //recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recent_adapter);



        btn_gift.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), FullScannerActivity.class);
              //  Intent i = new Intent(getActivity(), ReceiveActivity.class);


               // bit = BitmapFactory.decodeResource(getResources(),img.getImageAlpha());
    //   bit = BitmapFactory.decodeResource(getResources(),img.getId());
            //    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);stream = new ByteArrayOutputStream();


              //  bit.compress(Bitmap.CompressFormat.PNG,100,stream);
              //  bit.compress(Bitmap.CompressFormat.PNG, 100, stream);
               // byte[] byteArray = stream.toByteArray();

//                i.putExtra("picture",img.getImageAlpha());

                startActivity(i);
              //  startActivity(i);

            }
        });
        // btn_send.setOnClickListener(this);
        btn_redeem.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ReceiveActivity.class);
                startActivity(i);
            }
        });
        prepareValues();

        //for toolbar

        //for toolbar

       //initToolBar();
        /*toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white_18dp);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(getContext(), MainActivity.class);
                        startActivity(i);
                    }
                }
        );*/
return view;
    }



    private void prepareValues() {


        Recent_activities a = new Recent_activities("ABC", "gifted", "200");
        recent_activities.add(a);

        a = new Recent_activities("XYZ", "redeemed", "500");
        recent_activities.add(a);

        a = new Recent_activities("ABC", "gifted", "100");
        recent_activities.add(a);

        a = new Recent_activities("MNO", "redeemed", "800");
        recent_activities.add(a);

        a = new Recent_activities("XYZ", "redeemed", "500");
        recent_activities.add(a);

        a = new Recent_activities("ABC", "gifted", "100");
        recent_activities.add(a);

        a = new Recent_activities("MNO", "redeemed", "800");
        recent_activities.add(a);
        a = new Recent_activities("XYZ", "redeemed", "500");
        recent_activities.add(a);

        a = new Recent_activities("ABC", "gifted", "100");
        recent_activities.add(a);

        a = new Recent_activities("MNO", "redeemed", "800");
        recent_activities.add(a);

        recent_adapter.notifyDataSetChanged();
    }

  // public void initToolBar() {
        //toolbar = (Toolbar) findViewById(R.id.toolbar_Main);
       // toolbar.setTitle(R.string.toolbarMain);
       // toolbar.setTitleTextColor(0xFFFFFFFF);
     //   setSupportActionBar(toolbar);

    }








