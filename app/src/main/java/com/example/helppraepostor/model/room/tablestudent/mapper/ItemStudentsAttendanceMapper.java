package com.example.helppraepostor.model.room.tablestudent.mapper;

import com.example.helppraepostor.converter.AttendanceLectureConverterGson;
import com.example.helppraepostor.model.ItemStudentsAttendanceDto;
import com.example.helppraepostor.model.room.tablestudent.entity.ItemStudentsAttendanceEntity;

public class ItemStudentsAttendanceMapper {
    public static ItemStudentsAttendanceDto fromEntity(ItemStudentsAttendanceEntity itemStudentsAttendanceEntity) {
        ItemStudentsAttendanceDto dto = new ItemStudentsAttendanceDto();
        dto.setAttendance(itemStudentsAttendanceEntity.isAttendance());
        dto.setItemData(itemStudentsAttendanceEntity.getItemData());
        dto.setAttendanceLecture(AttendanceLectureConverterGson.toList(itemStudentsAttendanceEntity.getAttendanceLecture()));
        dto.setKeyName(itemStudentsAttendanceEntity.getKeyName());
        return dto;
    }

    public static ItemStudentsAttendanceEntity toEntity(ItemStudentsAttendanceDto dto) {
        ItemStudentsAttendanceEntity entity = new ItemStudentsAttendanceEntity();
        entity.setAttendance(dto.isAttendance());
        entity.setKeyName(dto.getKeyName());
        entity.setAttendanceLecture(AttendanceLectureConverterGson.fromList(dto.getAttendanceLecture()));
        entity.setItemData(dto.getItemData());
        return entity;
    }
}
