package com.example.helppraepostor.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AttendanceLectureConverterGson {
    private static final Gson gson = new Gson();

    @TypeConverter
    public static String fromList(List<Boolean> attendanceLectures) {
        if(attendanceLectures == null || attendanceLectures.isEmpty()) {
            return "[]";
        }
        return gson.toJson(attendanceLectures);
    }

    @TypeConverter
    public static List<Boolean> toList(String attendanceLectures) {
        if(attendanceLectures == null || attendanceLectures.isEmpty()) {
            return new ArrayList<>();
        }
        Type type = new TypeToken<List<Boolean>>(){}.getType();
        return gson.fromJson(attendanceLectures, type);
    }
}
