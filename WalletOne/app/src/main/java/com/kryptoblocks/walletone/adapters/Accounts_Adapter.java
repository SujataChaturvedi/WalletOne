package com.kryptoblocks.walletone.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kryptoblocks.walletone.R;
import com.kryptoblocks.walletone.pojo.Accounts_List;
import com.kryptoblocks.walletone.pojo.Activities_Card_List;

import java.util.List;

/**
 * Created by Admin on 29-11-2017.
 */

public class Accounts_Adapter extends RecyclerView.Adapter<Accounts_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Accounts_List> accounts_lists;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView label_tv, balance_tv, activity_tv;


        public MyViewHolder(View view) {
            super(view);
            label_tv = (TextView) view.findViewById(R.id.tv_label);
            balance_tv = (TextView) view.findViewById(R.id.tv_balance);
            activity_tv = (TextView) view.findViewById(R.id.tv_activity);
        }
    }

    public Accounts_Adapter(Context mContext, List<Accounts_List> accounts_lists) {
        this.mContext = mContext;
        this.accounts_lists = accounts_lists;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_list_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Accounts_Adapter.MyViewHolder holder, int position) {

        Accounts_List lis = accounts_lists.get(position);
        holder.label_tv.setText(lis.getLabel());
        holder.balance_tv.setText(String.valueOf(lis.getBalance()));
        holder.activity_tv.setText(lis.getLast_activity());

    }

    @Override
    public int getItemCount() {

        return accounts_lists.size();

    }
}
