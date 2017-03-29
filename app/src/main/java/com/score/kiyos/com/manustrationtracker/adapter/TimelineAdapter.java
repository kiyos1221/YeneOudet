package com.score.kiyos.com.manustrationtracker.adapter;

import android.support.graphics.drawable.VectorDrawableCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.R;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;

import org.joda.time.Days;

/**
 * Created by Kiyos on 3/22/2017.
 */

public class TimelineAdapter extends BaseAdapter {

    int position;

    public TimelineAdapter(int position) {
        this.position = position;
    }

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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_timeline, parent, false);
        int manDate = DateUtils.getNextMenstruation(parent.getContext(), this.position);

        TextView title = (TextView) convertView.findViewById(R.id.textView1);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        date.setText(manDate + "-" + (DateUtils.addMensturationDate(parent.getContext(), this.position + 1)));
        View status = convertView.findViewById(R.id.view1);
        if (position % 2 == 0) {
            status.setBackgroundDrawable(VectorDrawableCompat.create(parent.getContext().getResources(), R.drawable.ovary, parent.getContext().getTheme()));
            title.setText("በዚህ ጊዜ የሚደረግ ግንኙነት ለ እርግዝና ያበቃል");
        } else {
            status.setBackgroundDrawable(VectorDrawableCompat.create(parent.getContext().getResources(), R.drawable.ic_menstration, parent.getContext().getTheme()));
            title.setText("የወር አበባ ታያለሽ");
        }


        return convertView;
    }
}
