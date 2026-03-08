package com.example.helppraepostor.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemStudentsAttendanceDto {
    private String itemData;
    private String keyName;
    private boolean attendance;
    private List<Boolean> attendanceLecture; //index = Lecture
}
