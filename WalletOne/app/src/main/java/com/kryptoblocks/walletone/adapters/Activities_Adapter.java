package com.kryptoblocks.walletone.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kryptoblocks.walletone.pojo.Activities_Card_List;
import com.kryptoblocks.walletone.R;
import java.util.List;

/**
 * Created by Admin on 16-10-2017.
 */

public class Activities_Adapter extends RecyclerView.Adapter<Activities_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Activities_Card_List> activities_Card_List;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, date, amt, time, status;



        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tv_name_activities);
            date = (TextView) view.findViewById(R.id.tv_date_activities);
            amt = (TextView) view.findViewById(R.id.tv_amt_activities);
            time = (TextView) view.findViewById(R.id.tv_time_activities);
            status = (TextView) view.findViewById(R.id.tv_status_activities);

        }
    }

    public Activities_Adapter(Context mContext, List<Activities_Card_List> activities_Card_List) {
        this.mContext = mContext;
        this.activities_Card_List = activities_Card_List;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_activities, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Activities_Card_List lis = activities_Card_List.get(position);
        holder.name.setText(lis.getSent_to());
        holder.date.setText(lis.getDate());
        holder.amt.setText(lis.getAmt());
        holder.time.setText(lis.getTime());
        holder.status.setText(lis.getStatus());


    }

    @Override
    public int getItemCount() {

        return activities_Card_List.size();

    }
}
