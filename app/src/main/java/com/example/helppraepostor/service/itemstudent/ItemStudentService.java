package com.example.helppraepostor.service.itemstudent;

import com.example.helppraepostor.model.ItemStudent;

import java.util.List;

public interface ItemStudentService {
    void saveStudent(ItemStudent student);
    void updateStudent(ItemStudent student);
    void deleteStudent(String name);
    void deleteStudents();
    List<ItemStudent> getItemStudents() throws InterruptedException;
}
