package com.example.helppraepostor.model.room.tablestudent.mapper;

import com.example.helppraepostor.converter.AttendanceLectureConverterGson;
import com.example.helppraepostor.model.ItemStudentsAttendanceDto;
import com.example.helppraepostor.model.room.tablestudent.entity.ItemStudentsAttendanceEntity;

public class ItemStudentsAttendanceMapper {
    public static ItemStudentsAttendanceDto fromEntity(ItemStudentsAttendanceEntity itemStudentsAttendanceEntity) {
        ItemStudentsAttendanceDto dto = new ItemStudentsAttendanceDto();
        dto.setAttendance(itemStudentsAttendanceEntity.isAttendance());
        dto.setItemData(itemStudentsAttendanceEntity.getItemDate());
        dto.setAttendanceLecture(AttendanceLectureConverterGson.toList(itemStudentsAttendanceEntity.getAttendanceLecture()));
        dto.setStudentName(itemStudentsAttendanceEntity.getStudentName());
        return dto;
    }

    public static ItemStudentsAttendanceEntity toEntity(ItemStudentsAttendanceDto dto) {
        ItemStudentsAttendanceEntity entity = new ItemStudentsAttendanceEntity();
        entity.setAttendance(dto.isAttendance());
        entity.setStudentName(dto.getStudentName());
        entity.setAttendanceLecture(AttendanceLectureConverterGson.fromList(dto.getAttendanceLecture()));
        entity.setItemDate(dto.getItemData());
        return entity;
    }
}
