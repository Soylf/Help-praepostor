package com.example.helppraepostor.service;

import com.example.helppraepostor.model.ItemStudent;

import java.util.List;

public interface Service {
    void saveStudent(ItemStudent student);
    void deleteStudent(String name);
    void deleteStudents();
    List<ItemStudent> getItemStudents();
}
