package com.example.helppraepostor.model.room.tablestudent.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.helppraepostor.model.room.itemstudent.entity.ItemStudentEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(tableName = "students_attendance",
        foreignKeys = @ForeignKey(
                entity = ItemStudentEntity.class,
                parentColumns = "name",
                childColumns = "studentName",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = "studentName")}
)
public class ItemStudentsAttendanceEntity {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String itemDate;
    private String studentName;
    private boolean attendance;
    private String attendanceLecture; //index = Lecture
}
