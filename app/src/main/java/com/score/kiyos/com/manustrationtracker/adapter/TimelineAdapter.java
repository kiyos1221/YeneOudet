package com.score.kiyos.com.manustrationtracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.R;

/**
 * Created by Kiyos on 3/22/2017.
 */

public class TimelineAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_timeline, parent,false);
        TextView title = (TextView) convertView.findViewById(R.id.textView1);
        TextView date = (TextView) convertView.findViewById(R.id.textView1);
        View status = convertView.findViewById(R.id.view1);
        if(position%2==0){
            status.setBackgroundResource(R.drawable.ovary);
            title.setText("በዚህ ጊዜ የሚደረግ ግንኙነት ለ እርግዝና ያበቃል");
        }
        else{
            status.setBackgroundResource(R.drawable.ic_menstration);
            title.setText("የወር አበባ ታያለሽ");
        }



        return convertView;
    }
}
