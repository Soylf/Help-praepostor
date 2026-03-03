package com.example.helppraepostor.service.tablestudent.calendar;

import com.example.helppraepostor.model.ItemDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarServiceImpl implements CalendarService{
    private int currentYear;
    private int currentMonth;

    public CalendarServiceImpl() {
        Calendar today = Calendar.getInstance();
        this.currentYear = today.get(Calendar.YEAR);
        this.currentMonth = today.get(Calendar.MONTH);
    }

    @Override
    public int getCurrentMonth() {
        return currentMonth;
    }

    @Override
    public int getCurrentYear() {
        return currentYear;
    }

    @Override
    public void nextMonth() {
        currentMonth++;
        if(currentMonth > 11) {
            currentMonth = 0;
            currentYear++;
        }
    }

    @Override
    public void prevMonth() {
        currentMonth--;
        if(currentMonth < 0) {
            currentMonth = 11;
            currentYear--;
        }
    }

    @Override
    public List<ItemDay> generatedMonth() {
        List<ItemDay> days = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.set(currentYear, currentMonth, 1);

        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        //предыдущий
        cal.add(Calendar.MONTH, -1);
        int prevMonth = cal.get(Calendar.MONTH);
        int prevYear = cal.get(Calendar.YEAR);
        int daysInPrevMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        //обратно
        cal.add(Calendar.MONTH, 1);

        int emptyCells = firstDayOfWeek - 1;

        for (int i = emptyCells; i > 0; i--) {
            days.add(new ItemDay(
                    daysInPrevMonth - i + 1,
                    false,
                    prevMonth,
                    prevYear
            ));
        }

        //текущий
        for (int i = 1; i <= daysInMonth; i++) {
            days.add(new ItemDay(
                    i,
                    true,
                    currentMonth,
                    currentYear
            ));
        }

        // следующий
        cal.add(Calendar.MONTH, 1);
        int nextMonth = cal.get(Calendar.MONTH);
        int nextYear = cal.get(Calendar.YEAR);

        int nextDay = 1;
        while (days.size() % 7 != 0) {
            days.add(new ItemDay(
                    nextDay++,
                    false,
                    nextMonth,
                    nextYear
            ));
        }

        return days;
    }

    @Override
    public String getMonthAndYear() {
        String[] months = new java.text.DateFormatSymbols(new java.util.Locale("ru")).getMonths();
        return months[currentMonth] + " " + currentYear;
    }
}
