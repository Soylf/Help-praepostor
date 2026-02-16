package com.example.helppraepostor.model.room.itemstudent.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(tableName = "students")
public class ItemStudentEntity {
    @PrimaryKey
    @NonNull //androidx.annotation
    private String name;
    private String age;
    @ColumnInfo(name = "precedency_json")
    private String studentsPrecedencyJson;
    private boolean presentStudent; //Есть в колледже или нет
}
