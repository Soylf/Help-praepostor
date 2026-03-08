package com.example.helppraepostor.service.itemstudent;

import android.content.Context;

import com.example.helppraepostor.model.ItemStudentDto;
import com.example.helppraepostor.repository.ItemStudentRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemStudentServiceImpl implements ItemStudentService {
    private final ItemStudentRepository repository;

    public ItemStudentServiceImpl(Context context) {
        this.repository = new ItemStudentRepository(context);
    }

    @Override
    public void saveStudent(@NotNull ItemStudentDto student) {
        repository.save(student);
    }

    @Override
    public void updateStudent(ItemStudentDto student) {
        repository.update(student);
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
    public List<ItemStudentDto> getItemStudents() throws InterruptedException {
       return repository.getAll();
    }

//    private Map<String, ItemStudent> transformInMap(String keyNameStudent, ItemStudent itemStudent) {
//        Map<String, ItemStudent> itemStudentMap = new HashMap<>();
//        ItemStudentStorage.checkKeyStudentNameUnique(keyNameStudent);
//        itemStudentMap.put(keyNameStudent, itemStudent);
//        return itemStudentMap;
//    }
}