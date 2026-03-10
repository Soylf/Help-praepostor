package com.example.helppraepostor.model.room.tablestudent.pojo;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.helppraepostor.model.room.itemstudent.entity.ItemStudentEntity;
import com.example.helppraepostor.model.room.tablestudent.entity.ItemStudentsAttendanceEntity;

import java.util.List;

public class ItemStudentsAttendancePojo {
    @Embedded
    public ItemStudentEntity student;

    @Relation(
            parentColumn = "name",
            entityColumn = "studentName")
    public List<ItemStudentsAttendanceEntity> attendance;
}
