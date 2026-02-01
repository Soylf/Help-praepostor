package com.example.helppraepostor.repository;

import android.content.Context;

import com.example.helppraepostor.database.ItemStudentDatabase;
import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.model.room.dao.ItemStudentDao;
import com.example.helppraepostor.model.room.entity.ItemStudentEntity;
import com.example.helppraepostor.model.room.mapper.ItemStudentMapper;

import java.util.ArrayList;
import java.util.List;


public class ItemStudentRepository {
    private final ItemStudentDao dao;

    public ItemStudentRepository(Context context) {
        this.dao = ItemStudentDatabase.getInstance(context).studentDao();
    }

    public void save(ItemStudent itemStudent) {
        new Thread(() -> {
            dao.insert(ItemStudentMapper.toEntity(itemStudent));
        }).start();
    }

    public void deleteById(String name) {
        new Thread(() -> {
            dao.deleteByName(name);
        }).start();
    }

    public void deleteAll() {
        new Thread(dao::deleteAll).start();
    }

    public List<ItemStudent> getAll() throws InterruptedException {
        List<ItemStudentEntity> entities = new ArrayList<>();
        Thread thread = new Thread(() -> {
            entities.addAll(dao.getAll());
        });
        thread.start();
        thread.join();//Ждет завершщенич

        List<ItemStudent> students = new ArrayList<>();
        entities.forEach(a -> {
            students.add(ItemStudentMapper.fromEntity(a));
        });

        return students;
    }
}
