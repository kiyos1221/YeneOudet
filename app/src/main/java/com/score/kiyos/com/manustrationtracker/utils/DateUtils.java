package com.score.kiyos.com.manustrationtracker.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.score.kiyos.com.manustrationtracker.database.RealmPeriodController;
import com.score.kiyos.com.manustrationtracker.model.PeriodDate;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.chrono.EthiopicChronology;

import java.util.Date;

/**
 * Created by Kiyos on 3/20/2017.
 */

public class DateUtils {

    private static Chronology chronology = EthiopicChronology.getInstance();

    private static int year;

    private static int month;

    public static DateTime getToday() {

        return new DateTime(chronology);
    }

    public static int getDate() {
        return getToday().getDayOfMonth();
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

    public static int getMonthInPosition(int m) {
        LocalDate monthBegin = new LocalDate(chronology).plusMonths(m).withDayOfMonth(1);
        return monthBegin.getMonthOfYear();
    }

    public static String addMonth(int num) {
        LocalDate localDate = new LocalDate(chronology).plusMonths(num);
        year = localDate.getYear();
        month = localDate.getMonthOfYear();
        return Constants.MONTHS[month - 1] + " " + year;
    }

    public static int getNumberOfDays(int num) {
        DateTime localDate = new DateTime(chronology).plusMonths(num);
        return localDate.dayOfMonth().getMaximumValue();
    }

    public static int getDaysLeftForTheNext(Context context){
        PeriodDate periodDate = RealmPeriodController.with(context).getPeriodDate();

        DateTime dateTime = new DateTime(chronology).withDayOfMonth(periodDate.getDayOfMonth()).withMonthOfYear(periodDate.getMonthOfYear()).withYear(periodDate.getYear()).plusDays(periodDate.getCycleDuration() * month);

        int monthsInBetween = getToday().plusMonths(1).getMonthOfYear() - dateTime.getMonthOfYear();

        Log.d("Months In Between", String.valueOf(monthsInBetween));

        return Math.abs(Days.daysBetween(DateUtils.getToday().plusMonths(1), dateTime).getDays()) - (monthsInBetween*periodDate.getCycleDuration());
    }


    @NonNull
    public static DateTime getLocalDateWithGivenMonth(Context fragment, int month) {

        PeriodDate periodDate = RealmPeriodController.with(fragment).getPeriodDate();

        DateTime dateTime = new DateTime(chronology).withDayOfMonth(periodDate.getDayOfMonth()).withMonthOfYear(periodDate.getMonthOfYear()).withYear(periodDate.getYear()).plusDays(periodDate.getCycleDuration() * month);

        return dateTime;
    }

    public static DateTime getPeriodWithGivenMonth(Context fragment, int month) {

        PeriodDate periodDate = RealmPeriodController.with(fragment).getPeriodDate();

        DateTime dateTime = new DateTime(chronology).
                withDayOfMonth(periodDate.getDayOfMonth()).
                withMonthOfYear(periodDate.getMonthOfYear()).
                withYear(periodDate.getYear());

        return dateTime;
    }
    @NonNull
    public static LocalDate getLocalDateOfLastManistration(Context fragment) {

        PeriodDate periodDate = RealmPeriodController.with(fragment).getPeriodDate();

        LocalDate localDate = new LocalDate(chronology).withDayOfMonth(periodDate.getDayOfMonth()).withMonthOfYear(periodDate.getMonthOfYear()).withYear(periodDate.getYear());

        int numberOfMonthsInBetween = Days.daysBetween(localDate, new LocalDate(chronology)).getDays();

        Log.d("The Number of days ", Constants.MONTHS[periodDate.getMonthOfYear()]+" "+String.valueOf(numberOfMonthsInBetween));

        return localDate;
    }



    @NonNull
    public static LocalDate getLocalDateWithGivenDays(Context fragment, int days) {

        PeriodDate periodDate = RealmPeriodController.with(fragment).getPeriodDate();

        return new LocalDate(chronology).withDayOfMonth(periodDate.getDayOfMonth()).withMonthOfYear(periodDate.getMonthOfYear()).withYear(periodDate.getYear()).plusDays(days);
    }

    public static int getNextMenstruation(Context context, int month) {
        return getLocalDateWithGivenMonth(context, month).getDayOfMonth();
    }
    public static String getNextMenstruationMonth(Context context, int month) {
        return Constants.MONTHS[getLocalDateWithGivenMonth(context, month).getMonthOfYear()];
    }

    public static String getMonthName(Context context, int month) {
        return Constants.MONTHS[getLocalDateWithGivenMonth(context, month).getMonthOfYear()];
    }

    public static int addMensturationDate(Context context, int month) {
        return getLocalDateWithGivenMonth(context, month).plusDays(RealmPeriodController.with(context).getPeriodDate().getFlowDate()).getDayOfMonth();
    }
}
