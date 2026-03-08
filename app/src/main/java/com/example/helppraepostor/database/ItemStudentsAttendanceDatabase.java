package com.example.helppraepostor.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.helppraepostor.converter.ItemStudentConvertersGson;
import com.example.helppraepostor.model.room.tablestudent.dao.ItemStudentsAttendanceDao;
import com.example.helppraepostor.model.room.tablestudent.entity.ItemStudentsAttendanceEntity;

@Database(entities = {ItemStudentsAttendanceEntity.class}, version = 1, exportSchema = false)
@TypeConverters(ItemStudentConvertersGson.class)
public abstract class ItemStudentsAttendanceDatabase extends RoomDatabase {
    private static volatile ItemStudentsAttendanceDatabase INSTANCE;
    public abstract ItemStudentsAttendanceDao studentsAttendanceDao();

    public static ItemStudentsAttendanceDatabase getInstance(Context context) {
        if(INSTANCE == null) {
            synchronized (ItemStudentsAttendanceDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ItemStudentsAttendanceDatabase.class,
                            "students_attendance"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}
