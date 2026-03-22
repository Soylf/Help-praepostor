package com.example.helppraepostor.model.room.tablestudent.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.helppraepostor.model.room.tablestudent.entity.ItemStudentsAttendanceEntity;
import com.example.helppraepostor.model.room.tablestudent.pojo.ItemStudentsAttendancePojo;

@Dao
public interface ItemStudentsAttendanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ItemStudentsAttendanceEntity entity);

    @Transaction
    @Query("SELECT * FROM students WHERE name = :studentName")
    ItemStudentsAttendancePojo attendance(String studentName);
}