package com.example.helppraepostor.service.tablestudent.factory;

import com.example.helppraepostor.service.tablestudent.CalendarService;
import com.example.helppraepostor.service.tablestudent.CalendarServiceImpl;

public class CalendarServiceFactory {
    private CalendarServiceFactory() {}

    public static CalendarService calendarService() {
        return new CalendarServiceImpl();
    }
}
