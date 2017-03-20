package com.score.kiyos.com.manustrationtracker.utils;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.EthiopicChronology;

/**
 * Created by Kiyos on 3/20/2017.
 */

public class DateUtils {

    private static DateTime dateTime;

    private static Chronology chronology = EthiopicChronology.getInstance();

    private static DateTime getToday() {

        dateTime = new DateTime(chronology);

        return dateTime;
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
        return Constants.MONTHS[getToday().getMonthOfYear()-1];
    }

    public static String getMonthName(int monthOfYear){
        return Constants.MONTHS[monthOfYear];
    }
}
