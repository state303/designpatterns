package io.dsub.creational.factory;

import java.util.Calendar;
import java.util.TimeZone;

public class EverydayExample {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

        Calendar otherCal = Calendar.getInstance(TimeZone.getTimeZone(""));
    }
}
