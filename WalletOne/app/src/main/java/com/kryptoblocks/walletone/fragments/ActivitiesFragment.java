package com.kryptoblocks.walletone.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.kryptoblocks.walletone.adapters.Activities_Adapter;
import com.kryptoblocks.walletone.pojo.Activities_Card_List;
import com.kryptoblocks.walletone.R;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivitiesFragment extends Fragment {

    RecyclerView rv;
    Button show_btn, sorting_btn, back_btn;
    private RecyclerView recyclerView;
    Activities_Adapter adapter;

    public ActivitiesFragment() {
        // Required empty public constructor
    }

    private List<Activities_Card_List> activities_Card_List;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.activities_recycler_view);

        activities_Card_List = new ArrayList<>();
        adapter = new Activities_Adapter(getActivity(), activities_Card_List);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        sorting_btn = (Button) view.findViewById(R.id.sort_btn);
        sorting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(getContext(), sorting_btn);
                popup.getMenuInflater().inflate(R.menu.activities_sort_menu, popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getContext(), "To be implemented using API", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

            }
        });


        back_btn = (Button) view.findViewById(R.id.backup_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("message/rfc822");
                startActivity(emailIntent.createChooser(emailIntent, "Share using"));
                Snackbar.make(view, "Email", Snackbar.LENGTH_LONG).setAction("Action", null).show();

               // Toast.makeText(getContext(), "TBD with Sweta n Anubhav", Toast.LENGTH_SHORT).show();
            }
        });

     //   show_btn = (Button) view.findViewById(R.id.show_all_btn);

      /*  show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "To be impelemnted using API", Toast.LENGTH_SHORT).show();
            }
        });*/


        prepareValues();
        return view;
    }

    private void prepareValues() {


        Activities_Card_List a = new Activities_Card_List("ABC", "12-aug-2015", "200", "7:43 pm","Processing");
        activities_Card_List.add(a);

        a = new Activities_Card_List("XYZ", "6-jan-2015", "7800", "9:00 am","Confirmed");
        activities_Card_List.add(a);

        a = new Activities_Card_List("MNO", "30-feb-2015", "1200", "8.23 pm","Confirmed");
        activities_Card_List.add(a);

        a = new Activities_Card_List("ABC", "12-aug-2015", "200", "7:43pm","Processing");
        activities_Card_List.add(a);

        a = new Activities_Card_List("ABC", "12-aug-2015", "200", "7:43pm","Processing");
        activities_Card_List.add(a);

        a = new Activities_Card_List("ABC", "12-aug-2015", "200", "7:43pm","Processing");
        activities_Card_List.add(a);

        a = new Activities_Card_List("ABC", "12-aug-2015", "200", "7:43pm","Processing");
        activities_Card_List.add(a);

        a = new Activities_Card_List("ABC", "12-aug-2015", "200", "7:43pm","Processing");
        activities_Card_List.add(a);

        a = new Activities_Card_List("ABC", "12-aug-2015", "200", "7:43pm","Processing");
        activities_Card_List.add(a);

        adapter.notifyDataSetChanged();
    }

}


