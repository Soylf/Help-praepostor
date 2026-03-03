package com.example.helppraepostor.service.tablestudent.calendar;

import com.example.helppraepostor.model.ItemDay;

import java.util.List;

public interface CalendarService {
    int getCurrentMonth();
    int getCurrentYear();

    void nextMonth();
    void prevMonth();
    List<ItemDay> generatedMonth();

    String getMonthAndYear();
}
