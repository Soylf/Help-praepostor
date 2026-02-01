package com.example.helppraepostor.service;

import com.example.helppraepostor.model.ItemStudent;

import java.util.List;

public interface StudentService {
    void saveStudent(ItemStudent student);
    void deleteStudent(String name);
    void deleteStudents();
    List<ItemStudent> getItemStudents() throws InterruptedException;
}
