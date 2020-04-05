package com.weborders.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {
    /**
     * MM to specify month in double digit numbers ex: 01,02,03
     * MMM to specify month in 3 letters Jan,Feb,Mar
     * dd - to specify day in double digits ex: 01,02,04
     * yyyy - to specify year in 4 digit format
     * check format cheat sheet for more options
     * @param format
     * @return
     */
    public static String getTodaysDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }

    /**
     *
     * @param start
     * @param end
     * @param format h:m a format
     * @return
     */
    public static long getTimeDifference(String start , String end, String format){
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));

        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));

        return ChronoUnit.HOURS.between(startTime,endTime);
    }
}
