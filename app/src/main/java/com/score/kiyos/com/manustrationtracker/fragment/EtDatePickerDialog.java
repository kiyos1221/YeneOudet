package com.score.kiyos.com.manustrationtracker.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.score.kiyos.com.manustrationtracker.IDatePickerInterface;
import com.score.kiyos.com.manustrationtracker.R;
import com.score.kiyos.com.manustrationtracker.utils.Constants;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;
import com.shawnlin.numberpicker.NumberPicker;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.EthiopicChronology;

import java.util.Calendar;

/**
 * Created by Kiyos on 3/20/2017.
 */

public class EtDatePickerDialog extends android.support.v4.app.DialogFragment {

    OnDialogResultListener onDialogResultListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.date_time_layout, null);

        final NumberPicker day_picker = (NumberPicker) view.findViewById(R.id.day_picker);

        final NumberPicker month_picker = (NumberPicker) view.findViewById(R.id.month_picker);

        final NumberPicker year_picker = (NumberPicker) view.findViewById(R.id.year_picker);

        year_picker.setMinValue(DateUtils.getYear()-3);

        year_picker.setMaxValue(DateUtils.getYear());

        month_picker.setDisplayedValues(Constants.MONTHS);

        day_picker.setValue(DateUtils.getDate());

        month_picker.setValue(DateUtils.getMonth()-1);

        year_picker.setValue(DateUtils.getYear());

        builder.setTitle("እባክሽ ቀኑን ምረጪ ?");

        builder.setPositiveButton("መርጫለው", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onDialogResultListener.onPositiveResult(new int[]{day_picker.getValue(),month_picker.getValue(),year_picker.getValue()});
                Toast.makeText(getActivity(), day_picker.getValue()+"/"+Constants.MONTHS[month_picker.getValue()]+"/"+year_picker.getValue(), Toast.LENGTH_SHORT).show();
            }
        });

        builder.setView(view);

        return builder.create();
    }

    public interface OnDialogResultListener {
        void onPositiveResult(int[] value);
    }

    public void setOnDialogResultListener(OnDialogResultListener onDialogResultListener) {
        this.onDialogResultListener = onDialogResultListener;
    }
}
