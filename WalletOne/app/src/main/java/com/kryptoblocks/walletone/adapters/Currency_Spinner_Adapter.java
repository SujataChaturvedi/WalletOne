package com.kryptoblocks.walletone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.kryptoblocks.walletone.R;

/**
 * Created by Admin on 08-09-2017.
 */

public class Currency_Spinner_Adapter extends BaseAdapter {
    Context context;
    int flags[];
    String[] countryNames;
    LayoutInflater inflter;

    public Currency_Spinner_Adapter(Context applicationContext, int[] flags, String[] countryNames) {
        this.context = applicationContext;
        this.flags = flags;
        this.countryNames = countryNames;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.currency_spinner_items, null);
        ImageView icon = (ImageView) view.findViewById(R.id.spinner_imageView);
        TextView names = (TextView) view.findViewById(R.id.spinner_textView);



        //names.setTextColor(255);
        icon.setImageResource(flags[i]);
        names.setText(countryNames[i]);
        return view;
    }
}
