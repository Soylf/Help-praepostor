package com.example.helppraepostor.repository;

import android.content.Context;

import com.example.helppraepostor.database.ItemStudentsAttendanceDatabase;
import com.example.helppraepostor.model.room.tablestudent.dao.ItemStudentsAttendanceDao;

public class ItemStudentsAttendanceRepository {
    private final ItemStudentsAttendanceDao dao;

    public ItemStudentsAttendanceRepository(Context context) {
        this.dao = ItemStudentsAttendanceDatabase.getInstance(context).studentsAttendanceDao();
    }
}
