package com.example.helppraepostor.model.room.tablestudent.entity;

import java.util.List;

public class ItemStudentAttendanceEntity {
    private Long id;
    private String itemData;
    private boolean keyName;
    private boolean attendance;
    private List<Boolean> attendanceLecture; //index - Lecture
}
