package com.score.kiyos.com.manustrationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.score.kiyos.com.manustrationtracker.database.RealmPeriodController;
import com.score.kiyos.com.manustrationtracker.fragment.EtDatePickerDialog;
import com.score.kiyos.com.manustrationtracker.model.PeriodDate;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;
import com.shawnlin.numberpicker.NumberPicker;

public class SetupActivity extends AppCompatActivity{
    Button setDateButton, finishSetup;

    NumberPicker pickerForLong, pickerCycleIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup);

        setDateButton = (Button) findViewById(R.id.set_date_btn);

        pickerForLong = (NumberPicker) findViewById(R.id.picker_for_long);

        pickerCycleIn = (NumberPicker) findViewById(R.id.picker_for_cycle);

        finishSetup = (Button) findViewById(R.id.finish_setup);

        setDateButton.setText(DateUtils.getMonthName()+" "+DateUtils.getDate()+", "+DateUtils.getYear());

        setDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EtDatePickerDialog pickerDialog = new EtDatePickerDialog();

                pickerDialog.show(getSupportFragmentManager(), "TAG");

                pickerDialog.setOnDialogResultListener(new EtDatePickerDialog.OnDialogResultListener() {
                    @Override
                    public void onPositiveResult(int[] value) {
                        setDateButton.setText(DateUtils.getMonthName(value[1])+" "+value[0]+", "+value[2]);
                        PeriodDate periodDate = new PeriodDate();
                        periodDate.setId(1);
                        periodDate.setDayOfMonth(value[0]);
                        periodDate.setMonthOfYear(value[1]);
                        periodDate.setYear(value[2]);
                        periodDate.setCycleDuration(pickerCycleIn.getValue());
                        periodDate.setFlowDate(pickerForLong.getValue());
                        RealmPeriodController.with(SetupActivity.this).addPeriodDate(periodDate);
                    }
                });

            }
        });

        finishSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SetupActivity.this, MainActivity.class));
            }
        });

    }

}
