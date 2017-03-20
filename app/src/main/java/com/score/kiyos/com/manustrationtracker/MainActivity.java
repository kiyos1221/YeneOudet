package com.score.kiyos.com.manustrationtracker;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.score.kiyos.com.manustrationtracker.fragment.EtDatePickerDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ImageView hamIcon = (ImageView) findViewById(R.id.ham_icon);

        hamIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawers();
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }*/

                EtDatePickerDialog datePickerDialog = new EtDatePickerDialog();
                datePickerDialog.show(getSupportFragmentManager(), "Hi");
            }
        });

    }
}
