package com.example.helppraepostor.service;

import com.example.helppraepostor.adapter.ItemStudentAdapter;
import com.example.helppraepostor.model.ItemStudent;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private ItemStudentAdapter adapter;

    @Override
    public void saveStudent(ItemStudent student) {

    }

    @Override
    public void deleteStudent(String name) {

    }

    @Override
    public void deleteStudents() {

    }

    @Override
    public List<ItemStudent> getItemStudents() {
        return null;
    }
}
