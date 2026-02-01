package com.example.helppraepostor.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.helppraepostor.converter.ItemStudentConverters;
import com.example.helppraepostor.model.room.dao.ItemStudentDao;
import com.example.helppraepostor.model.room.entity.ItemStudentEntity;

@Database(entities = {ItemStudentEntity.class}, version = 1, exportSchema = false)
@TypeConverters(ItemStudentConverters.class)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract ItemStudentDao studentDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "item_students_db"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}