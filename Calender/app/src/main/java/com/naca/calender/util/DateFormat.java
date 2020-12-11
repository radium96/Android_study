package com.naca.calender.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {
    public final static String CALENDAR_HEADER_FORMAT = "yyyy년 MM월";
    public final static String DAY_FORMAT = "d";

    public static String getDate(long date, String pattern) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
            Date d = new Date(date);
            return format.format(d).toUpperCase();
        } catch (Exception e){
            return " ";
        }
    }
}
