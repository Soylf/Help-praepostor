package com.example.helppraepostor.service.tablestudent.calendar.factory;

import com.example.helppraepostor.service.tablestudent.calendar.CalendarService;
import com.example.helppraepostor.service.tablestudent.calendar.CalendarServiceImpl;

public class CalendarServiceFactory {
    private CalendarServiceFactory() {}

    public static CalendarService calendarService() {
        return new CalendarServiceImpl();
    }
}
