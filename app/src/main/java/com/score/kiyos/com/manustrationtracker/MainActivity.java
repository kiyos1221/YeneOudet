package com.score.kiyos.com.manustrationtracker;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.adapter.MainActivityPagerAdapter;
import com.score.kiyos.com.manustrationtracker.database.RealmPeriodController;
import com.score.kiyos.com.manustrationtracker.utils.Constants;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;
import org.joda.time.PeriodType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        setContentView(R.layout.activity_main);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ImageView hamIcon = (ImageView) findViewById(R.id.ham_icon);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_main);

        for (int i = 0; i<90; i++){
            DateTime localDate = DateUtils.getLocalDateWithGivenMonth(this, i);
            Log.d("Dates", localDate.getDayOfMonth()+"/"+ Constants.MONTHS[localDate.getMonthOfYear()-1]+"/"+localDate.getYear());
        }

        viewPager.setAdapter(new MainActivityPagerAdapter(getSupportFragmentManager()));

        hamIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

    }
}
