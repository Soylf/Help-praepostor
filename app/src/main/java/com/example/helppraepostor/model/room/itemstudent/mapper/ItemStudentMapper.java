package com.example.helppraepostor.model.room.itemstudent.mapper;

import com.example.helppraepostor.converter.ItemStudentConvertersGson;
import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.model.room.itemstudent.entity.ItemStudentEntity;

public class ItemStudentMapper {
    public static ItemStudentEntity toEntity(ItemStudent itemStudent) {
        ItemStudentEntity itemStudentEntity = new ItemStudentEntity();
        itemStudentEntity.setName(itemStudent.getName());
        itemStudentEntity.setAge(itemStudent.getAge());
        itemStudentEntity.setStudentsPrecedencyJson(
                ItemStudentConvertersGson.fromList(itemStudent.getStudentsPrecedency())
        );
        return itemStudentEntity;
    }

    public static ItemStudent fromEntity(ItemStudentEntity itemStudentEntity) {
        ItemStudent itemStudent = new ItemStudent();
        itemStudent.setAge(itemStudentEntity.getAge());
        itemStudent.setName(itemStudentEntity.getName());
        itemStudent.setStudentsPrecedency(
                ItemStudentConvertersGson.toList(itemStudentEntity.getStudentsPrecedencyJson())
        );
        return itemStudent;
    }
}
