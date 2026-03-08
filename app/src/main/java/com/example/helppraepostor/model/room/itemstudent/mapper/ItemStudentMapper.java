package com.example.helppraepostor.model.room.itemstudent.mapper;

import com.example.helppraepostor.converter.ItemStudentConvertersGson;
import com.example.helppraepostor.model.ItemStudentDto;
import com.example.helppraepostor.model.room.itemstudent.entity.ItemStudentEntity;

public class ItemStudentMapper {
    public static ItemStudentEntity toEntity(ItemStudentDto itemStudentDto) {
        ItemStudentEntity itemStudentEntity = new ItemStudentEntity();
        itemStudentEntity.setName(itemStudentDto.getName());
        itemStudentEntity.setAge(itemStudentDto.getAge());
        itemStudentEntity.setPresentStudent(itemStudentDto.isPresentStudent());
        itemStudentEntity.setStudentsPrecedencyJson(
                ItemStudentConvertersGson.fromList(itemStudentDto.getStudentsPrecedency())
        );
        return itemStudentEntity;
    }

    public static ItemStudentDto fromEntity(ItemStudentEntity itemStudentEntity) {
        ItemStudentDto itemStudentDto = new ItemStudentDto();
        itemStudentDto.setAge(itemStudentEntity.getAge());
        itemStudentDto.setName(itemStudentEntity.getName());
        itemStudentDto.setPresentStudent(itemStudentEntity.isPresentStudent());
        itemStudentDto.setStudentsPrecedency(
                ItemStudentConvertersGson.toList(itemStudentEntity.getStudentsPrecedencyJson())
        );
        return itemStudentDto;
    }
}
