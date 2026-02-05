package com.example.helppraepostor.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.helppraepostor.converter.ItemStudentConvertersGson;
import com.example.helppraepostor.model.room.itemstudent.dao.ItemStudentDao;
import com.example.helppraepostor.model.room.itemstudent.entity.ItemStudentEntity;

@Database(entities = {ItemStudentEntity.class}, version = 1, exportSchema = false)
@TypeConverters(ItemStudentConvertersGson.class)
public abstract class ItemStudentDatabase extends RoomDatabase {

    private static volatile ItemStudentDatabase INSTANCE;

    public abstract ItemStudentDao studentDao();

    public static ItemStudentDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ItemStudentDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ItemStudentDatabase.class,
                            "item_students_db"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}