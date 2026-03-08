package com.example.helppraepostor.service.itemstudent;

import com.example.helppraepostor.model.ItemStudentDto;

import java.util.List;

public interface ItemStudentService {
    void saveStudent(ItemStudentDto student);
    void updateStudent(ItemStudentDto student);
    void deleteStudent(String name);
    void deleteStudents();
    List<ItemStudentDto> getItemStudents() throws InterruptedException;
}
