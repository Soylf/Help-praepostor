package com.example.helppraepostor.model.room.tablestudent.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.helppraepostor.model.room.tablestudent.entity.ItemStudentsAttendanceEntity;

@Dao
public interface ItemStudentsAttendanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ItemStudentsAttendanceEntity entity);
}
