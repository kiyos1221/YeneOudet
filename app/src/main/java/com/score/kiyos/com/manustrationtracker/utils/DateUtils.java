package com.score.kiyos.com.manustrationtracker.utils;

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

    public static String getDayName() {
        return Constants.DAYS[getToday().getDayOfWeek() - 1];
    }
}
