package com.example.helppraepostor.storage;

import com.example.helppraepostor.model.ItemStudent;

import java.util.Map;

import lombok.Builder;


@Builder
public class ItemStudentStorage {
    private static final ItemStudentStorage INSTANCE = ItemStudentStorage.builder().build();
    private Map<String, ItemStudent> itemStudentMap;

    public static Map<String, ItemStudent> getItemStudentMap() {
        return INSTANCE.itemStudentMap;
    }

    public static void setItemStudentMap(String keyStudentName, ItemStudent itemStudent) {
        try {
            checkKeyStudentNameUnique(keyStudentName);
            INSTANCE.itemStudentMap.put(keyStudentName, itemStudent);
        }catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteByKey(String name) {
        checkKeyStudentNameUnique(name);
        INSTANCE.itemStudentMap.remove(name);
    }

    public static void deleteAll() {
        INSTANCE.itemStudentMap.clear();
    }

    public static void checkKeyStudentNameUnique(String keyStudentName) {
        for(String name: INSTANCE.itemStudentMap.keySet()) { //containsKey
            if(keyStudentName.equals(name)) {
                throw new IllegalStateException("Такое имя уже есть: " + keyStudentName);
            }
        }
    }
}