package com.score.kiyos.com.manustrationtracker.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.score.kiyos.com.manustrationtracker.database.RealmPeriodController;
import com.score.kiyos.com.manustrationtracker.model.PeriodDate;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.chrono.EthiopicChronology;

/**
 * Created by Kiyos on 3/20/2017.
 */

public class DateUtils {

    private static Chronology chronology = EthiopicChronology.getInstance();

    private static DateTime getToday() {

        return new DateTime(chronology);
    }

    public static int getDate() {
        return getToday().getDayOfMonth();
    }

    public static int getDay() {
        return getToday().getDayOfWeek();
    }

    public static int getMonth() {
        return getToday().getMonthOfYear();
    }

    public static int getYear() {
        return getToday().getYear();
    }

    public static String getMonthName() {
        return Constants.MONTHS[getToday().getMonthOfYear() - 1];
    }

    public static String getMonthName(int monthOfYear) {
        return Constants.MONTHS[monthOfYear];
    }

    public static int getFirstDayOfMonth(int i) {
        LocalDate monthBegin = new LocalDate(chronology).plusMonths(i).withDayOfMonth(1);
        return monthBegin.getDayOfWeek();
    }
    public static int getMonthInPosition(int i) {
        LocalDate monthBegin = new LocalDate(chronology).plusMonths(i).withDayOfMonth(1);
        return monthBegin.getMonthOfYear();
    }

    public static String getDayName() {
        return Constants.DAYS[getToday().getDayOfWeek() - 1];
    }

    public static LocalDate addDay(int numberOfDays){
        return new LocalDate(chronology).plusDays(numberOfDays);
    }

    public static String addMonth(int num){
        LocalDate localDate = new LocalDate(chronology).plusMonths(num);
        int year = localDate.getYear();
        int month = localDate.getMonthOfYear();
        return Constants.MONTHS[month-1] +" "+ year;
    }
    public static String subtractMonth(int num){
        LocalDate localDate = new LocalDate(chronology).minusMonths(num);
        int year = localDate.getYear();
        int month = localDate.getMonthOfYear();
        return Constants.MONTHS[month-1] +" "+ year;
    }

    public static int getNextMenstration(Context fragment, int month){

        PeriodDate periodDate = RealmPeriodController.with(fragment).getPeriodDate();

        return new LocalDate(chronology).withDayOfMonth(periodDate.getDayOfMonth()).withMonthOfYear(periodDate.getMonthOfYear()).withYear(periodDate.getYear()).plusDays(periodDate.getCycleDuration()*month).getDayOfMonth();

    }


}
