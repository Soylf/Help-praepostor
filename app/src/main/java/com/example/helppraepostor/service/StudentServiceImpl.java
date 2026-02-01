package com.example.helppraepostor.service;

import android.content.Context;

import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.repository.ItemStudentRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final ItemStudentRepository repository;

    public StudentServiceImpl(Context context) {
        this.repository = new ItemStudentRepository(context);
    }

    @Override
    public void saveStudent(@NotNull ItemStudent student) {
        repository.save(student);
    }

    @Override
    public void deleteStudent(String name) {
        repository.deleteById(name);
    }

    @Override
    public void deleteStudents() {
        repository.deleteAll();
    }

    @Override
    public List<ItemStudent> getItemStudents() throws InterruptedException {
       return repository.getAll();
    }

//    private Map<String, ItemStudent> transformInMap(String keyNameStudent, ItemStudent itemStudent) {
//        Map<String, ItemStudent> itemStudentMap = new HashMap<>();
//        ItemStudentStorage.checkKeyStudentNameUnique(keyNameStudent);
//        itemStudentMap.put(keyNameStudent, itemStudent);
//        return itemStudentMap;
//    }
}