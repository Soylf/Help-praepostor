package com.example.helppraepostor.service;

import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.storage.ItemStudentStorage;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Override
    public void saveStudent(@NotNull ItemStudent student) {
        ItemStudentStorage.setItemStudentMap(student.getName(), student);
    }

    @Override
    public void deleteStudent(String name) {
        ItemStudentStorage.deleteByKey(name);
    }

    @Override
    public void deleteStudents() {
        ItemStudentStorage.deleteAll();
    }

    @Override
    public List<ItemStudent> getItemStudents() {
        return new ArrayList<>(ItemStudentStorage.getItemStudentMap().values());
    }

    private Map<String, ItemStudent> transformInMap(String keyNameStudent, ItemStudent itemStudent) {
        Map<String, ItemStudent> itemStudentMap = new HashMap<>();
        ItemStudentStorage.checkKeyStudentNameUnique(keyNameStudent);
        itemStudentMap.put(keyNameStudent, itemStudent);
        return itemStudentMap;
    }

}
