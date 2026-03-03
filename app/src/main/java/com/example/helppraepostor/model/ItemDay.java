package com.example.helppraepostor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDay {
    private int day;
    private boolean isCurrentMonth;
    private int month;
    private int year;

    public ItemDay(int day, boolean isCurrentMonth) {
        this.day = day;
        this.isCurrentMonth = isCurrentMonth;
    }

        public String ItemData() {return String.format("%s %s %s", day,month+1,year);}
}
