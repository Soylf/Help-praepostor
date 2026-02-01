package com.example.helppraepostor.model.room.mapper;

import com.example.helppraepostor.converter.ItemStudentConverters;
import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.model.room.entity.ItemStudentEntity;

public class ItemStudentMapper {
    public static ItemStudentEntity toEntity(ItemStudent itemStudent) {
        ItemStudentEntity itemStudentEntity = new ItemStudentEntity();
        itemStudentEntity.setName(itemStudent.getName());
        itemStudentEntity.setAge(itemStudent.getAge());
        itemStudentEntity.setStudentsPrecedencyJson(
                ItemStudentConverters.fromList(itemStudent.getStudentsPrecedency())
        );
        return itemStudentEntity;
    }

    public static ItemStudent fromEntity(ItemStudentEntity itemStudentEntity) {
        ItemStudent itemStudent = new ItemStudent();
        itemStudent.setAge(itemStudentEntity.getAge());
        itemStudent.setName(itemStudentEntity.getName());
        itemStudent.setStudentsPrecedency(
                ItemStudentConverters.toList(itemStudentEntity.getStudentsPrecedencyJson())
        );
        return itemStudent;
    }
}
