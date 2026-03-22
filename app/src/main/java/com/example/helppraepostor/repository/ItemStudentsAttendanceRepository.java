package com.example.helppraepostor.repository;

import android.content.Context;

import com.example.helppraepostor.database.ItemStudentsAttendanceDatabase;
import com.example.helppraepostor.model.ItemStudentsAttendanceDto;
import com.example.helppraepostor.model.room.tablestudent.dao.ItemStudentsAttendanceDao;
import com.example.helppraepostor.model.room.tablestudent.mapper.ItemStudentsAttendanceMapper;
import com.example.helppraepostor.model.room.tablestudent.pojo.ItemStudentsAttendancePojo;

import java.util.concurrent.atomic.AtomicReference;

public class ItemStudentsAttendanceRepository {
    private final ItemStudentsAttendanceDao dao;

    public ItemStudentsAttendanceRepository(Context context) {
        this.dao = ItemStudentsAttendanceDatabase.getInstance(context).studentsAttendanceDao();
    }

    public void save(ItemStudentsAttendanceDto dto) {
        new Thread(() -> {
            dao.insert(ItemStudentsAttendanceMapper.toEntity(dto));
        }).start();
    }

    public ItemStudentsAttendancePojo getAttendancePojo(String name) {
        AtomicReference<ItemStudentsAttendancePojo> pojo = new AtomicReference<>(new ItemStudentsAttendancePojo());
        new Thread(() ->{
            pojo.set(dao.attendance(name));
        }).start();
        return pojo.get();
    }
}
