package com.example.helppraepostor.model.room.tablestudent.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(tableName = "students_attendance")
public class ItemStudentsAttendanceEntity {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String itemData;
    private String keyName;
    private boolean attendance;
    private String attendanceLecture; //index = Lecture
}
