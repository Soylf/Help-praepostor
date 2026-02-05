package com.example.helppraepostor.model.room.itemstudent.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.helppraepostor.model.room.itemstudent.entity.ItemStudentEntity;

import java.util.List;

@Dao
public interface ItemStudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ItemStudentEntity student);

    @Query("SELECT * FROM students")
    List<ItemStudentEntity> getAll();

    @Query("DELETE FROM students WHERE name = :name")
    void deleteByName(String name);

    @Query("DELETE FROM students")
    void deleteAll();
}
