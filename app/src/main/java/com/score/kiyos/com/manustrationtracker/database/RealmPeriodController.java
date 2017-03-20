package com.score.kiyos.com.manustrationtracker.database;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.score.kiyos.com.manustrationtracker.model.PeriodDate;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Kiyos Solomon on 12/8/2016.
 */

public class RealmPeriodController {
    private static RealmPeriodController instance;
    private final Realm realm;

    public RealmPeriodController(Application application) {
        Realm.init (application);
        RealmConfiguration libraryConfig = new RealmConfiguration.Builder ()
                .name ("app.realm")
                .deleteRealmIfMigrationNeeded ()
                .build ();

        realm = Realm.getDefaultInstance ();
    }

    public static RealmPeriodController with(Fragment fragment) {

        if (instance == null) {
            Realm.init (fragment.getActivity ());
            instance = new RealmPeriodController (fragment.getActivity ().getApplication ());
        }
        return instance;

    }

    public static RealmPeriodController with(Activity activity) {
        if (instance == null) {
            Realm.init (activity);
            instance = new RealmPeriodController (activity.getApplication ());
        }
        return instance;
    }

    public static RealmPeriodController with(Application application) {

        if (instance == null) {
            Realm.init (application);
            instance = new RealmPeriodController (application);
        }
        return instance;
    }

    public static RealmPeriodController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.setAutoRefresh (true);
    }

    //clear all objects from Bookmark.class
    public void clearAll() {
        realm.beginTransaction ();
        realm.deleteAll ();
        realm.commitTransaction ();
    }

    //find all objects in the Bookmark.class
    public RealmResults<PeriodDate> getPeriodDate() {
        return realm.where (PeriodDate.class).findAll ();
    }

    public void addPeriodDate(final PeriodDate periodDate){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(periodDate);
            }
        });
    }


}