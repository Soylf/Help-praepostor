package com.example.helppraepostor.service;

import com.example.helppraepostor.model.ItemStudent;

public interface TableService {
    void saveStudent(ItemStudent student);
    void deleteStudent(String name);
    void deleteStudents();
    ItemStudent getItemStudents();
}
