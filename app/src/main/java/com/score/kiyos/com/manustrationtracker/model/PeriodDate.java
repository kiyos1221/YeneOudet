package com.score.kiyos.com.manustrationtracker.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Kiyos on 3/20/2017.
 */

public class PeriodDate extends RealmObject {

    @PrimaryKey
    int id;
    int dayOfMonth;
    int monthOfYear;
    int year;
    int cycleDuration;
    int flowDate;

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(int monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCycleDuration() {
        return cycleDuration;
    }

    public void setCycleDuration(int cycleDuration) {
        this.cycleDuration = cycleDuration;
    }

    public int getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(int flowDate) {
        this.flowDate = flowDate;
    }
}
