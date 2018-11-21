package com.kryptoblocks.walletone.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kryptoblocks.walletone.pojo.Recent_activities;
import com.kryptoblocks.walletone.R;
import java.util.List;

/**
 * Created by Admin on 23-10-2017.
 */

public class Recent_Activities_Adapter extends RecyclerView.Adapter<Recent_Activities_Adapter.MyViewHolder>{

private Context mContext;
private List<Recent_activities>recent_activities;


public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView name, field, amt;


    public MyViewHolder(View view) {
        super(view);
        name = (TextView) view.findViewById(R.id.recent_activities_name);
        field = (TextView) view.findViewById(R.id.recent_activities_gift_redeem);
        amt = (TextView) view.findViewById(R.id.recent_activities_points);

    }

}

    public Recent_Activities_Adapter(Context mContext, List<Recent_activities> recent_activities) {
        this.mContext = mContext;
        this.recent_activities = recent_activities;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recent_activities, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recent_activities lis = recent_activities.get(position);
        holder.name.setText(lis.getSent_to());
        holder.field.setText(lis.getField());
        holder.amt.setText(lis.getAmt());

    }


    @Override
    public int getItemCount() {

        return recent_activities.size();

    }
}

