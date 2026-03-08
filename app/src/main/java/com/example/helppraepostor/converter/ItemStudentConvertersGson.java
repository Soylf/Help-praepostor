package com.example.helppraepostor.converter;

import androidx.room.TypeConverter;

import com.example.helppraepostor.model.ItemStudentDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ItemStudentConvertersGson {
    private static final Gson gson = new Gson();

    @TypeConverter
    public static String fromList(List<ItemStudentDto> studentsPrecedency) {
        if (studentsPrecedency == null || studentsPrecedency.isEmpty()) {
            return "[]";
        }
        return gson.toJson(studentsPrecedency);
    }

    @TypeConverter
    public static List<ItemStudentDto> toList(String studentsPrecedencyJson) {
        if (studentsPrecedencyJson == null || studentsPrecedencyJson.isEmpty()) {
            return new ArrayList<>();
        }
        Type type = new TypeToken<List<ItemStudentDto>>(){}.getType();
        return gson.fromJson(studentsPrecedencyJson, type);
    }
}
