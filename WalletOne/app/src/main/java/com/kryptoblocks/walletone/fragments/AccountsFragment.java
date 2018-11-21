package com.kryptoblocks.walletone.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kryptoblocks.walletone.R;
import com.kryptoblocks.walletone.adapters.Accounts_Adapter;
import com.kryptoblocks.walletone.adapters.Activities_Adapter;
import com.kryptoblocks.walletone.pojo.Accounts_List;
import com.kryptoblocks.walletone.pojo.Activities_Card_List;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountsFragment extends Fragment {

    EditText txt_view;
    Button add, create;
    RecyclerView recycle;
    Accounts_Adapter acc_adap;
    Button create_vault,create_account;
    // private View alertView;
    //  LinearLayout lin_wallet,lin_vault;


    public AccountsFragment() {
        // Required empty public constructor
    }

    private List<Accounts_List> accounts_lists;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accounts, container, false);

        recycle = view.findViewById(R.id.account_recyclerview);
        accounts_lists = new ArrayList<>();
        acc_adap = new Accounts_Adapter(getApplicationContext(), accounts_lists);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recycle.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recycle.setItemAnimator(new DefaultItemAnimator());
        recycle.setAdapter(acc_adap);



        add = view.findViewById(R.id.addAccount_btn);
        create = view.findViewById(R.id.newAccount_btn);

      /*  add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog add_alert = new AlertDialog.Builder(getContext()).create();
                add_alert.setTitle("trial");
                LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                View alertView = inflater.inflate(R.layout.create_account_layout, null);
                add_alert.setView(alertView);
                add_alert.show();

            }
        });*/

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //final AlertDialog.Builder builder_main = new AlertDialog.Builder(getContext());
                final AlertDialog builder_main = new AlertDialog.Builder(getContext()).create();
                LayoutInflater inflater = LayoutInflater.from(getApplicationContext());

                View alertView = inflater.inflate(R.layout.create_account_layout, null);
                builder_main.setMessage("Create a new Account");
                builder_main.setView(alertView);
                builder_main.show();

                LinearLayout lin_wallet = alertView.findViewById(R.id.wallet_lin_lay);
                LinearLayout lin_vault = alertView.findViewById(R.id.vault_lin_lay);

                lin_wallet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final AlertDialog builder = new AlertDialog.Builder(getContext()).create();
                        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                        View alertView = inflater.inflate(R.layout.wallet_name_layout, null);

                        EditText et_wallet = alertView.findViewById(R.id.wallet_name_et);
                        ImageButton close_wallet = alertView.findViewById(R.id.close_image_button);
                        create_account = alertView.findViewById(R.id.btn_create_account);
                        //builder.setMessage("Create a wallet");
                        builder.setView(alertView);
                        builder_main.dismiss();

                        builder.show();

                       close_wallet.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                builder.dismiss();

                            }
                        });

                        create_account.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "Wallet created", Toast.LENGTH_SHORT).show();
                                builder.dismiss();
                            }
                        });



                    }
                });



                lin_vault.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final AlertDialog builder_vault = new AlertDialog.Builder(getContext()).create();
                        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                        View alertView = inflater.inflate(R.layout.vault_name_layout, null);

                        EditText et_wallet = alertView.findViewById(R.id.wallet_name_et);
                        ImageButton close_vault = alertView.findViewById(R.id.close_image_button);
                        create_vault = alertView.findViewById(R.id.btn_create_vault);
                        //builder_vault.setMessage("Create a new Vault");
                        builder_vault.setView(alertView);
                        builder_main.dismiss();

                        builder_vault.show();

                        close_vault.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                builder_vault.dismiss();

                            }
                        });

                        create_vault.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "Vault created", Toast.LENGTH_SHORT).show();
                                builder_vault.dismiss();
                            }
                        });



                    }
                });

            }
        });

        prepareValues();
        return view;
    }

    private void prepareValues() {


        Accounts_List a = new Accounts_List("Avinash", 78," 2 months ago");
        accounts_lists.add(a);

        a = new Accounts_List("Surbhi", 20,"5 days ago");
        accounts_lists.add(a);

        a = new Accounts_List("Maan", 100, "7 months ago");
        accounts_lists.add(a);

    }
}