package com.example.helppraepostor.storage;

import com.example.helppraepostor.model.ItemStudent;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class ItemStudentStorage {
    private static final ItemStudentStorage INSTANCE = ItemStudentStorage.builder().build();

    @Getter
    @Setter
    private static Map<String, ItemStudent> itemStudentMap;

    public static void deleteByKey(String name) {
        itemStudentMap.remove(name);
    }

    public static void deleteAll() {
        itemStudentMap.clear();
    }

    public static void checkKeyStudentNameUnique(String keyStudentName) {
        for(String name: itemStudentMap.keySet()) { //containsKey
            if(keyStudentName.equals(name)) {
                throw new IllegalStateException("Такое имя уже есть: " + keyStudentName);
            }
        }
    }
}