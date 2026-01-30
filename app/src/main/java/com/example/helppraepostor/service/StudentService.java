package com.example.helppraepostor.service;

import com.example.helppraepostor.model.ItemStudent;

import java.util.List;
import java.util.Map;

public interface StudentService {
    void saveStudent(ItemStudent student);
    void deleteStudent(String name);
    void deleteStudents();
    Map<String,ItemStudent> getItemStudents();
}
