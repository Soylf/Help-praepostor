package com.example.helppraepostor.service.factory;

import android.content.Context;

import com.example.helppraepostor.service.ItemStudentService;
import com.example.helppraepostor.service.ItemStudentServiceImpl;

public final class ItemStudentServiceFactory {

    private static ItemStudentService itemStudentService;

    private ItemStudentServiceFactory() {}

    public static ItemStudentService getStudentService(Context context) {
        if (itemStudentService == null) {
            itemStudentService = new ItemStudentServiceImpl(context.getApplicationContext());
        }
        return itemStudentService;
    }
}
