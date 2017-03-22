package com.score.kiyos.com.manustrationtracker;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Kiyos on 3/20/2017.
 */

public class PeriodApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
