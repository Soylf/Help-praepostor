package com.example.helppraepostor.service;

import com.example.helppraepostor.adapter.ItemStudentAdapter;
import com.example.helppraepostor.model.ItemStudent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TableServiceImpl implements TableService{
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
    public ItemStudent getItemStudents() {
        return null;
    }
}
