package com.example.helppraepostor.service.factory;

import android.content.Context;

import com.example.helppraepostor.service.StudentService;
import com.example.helppraepostor.service.StudentServiceImpl;

public final class ServiceFactory {

    private static StudentService studentService;

    private ServiceFactory() {}

    public static StudentService getStudentService(Context context) {
        if (studentService == null) {
            studentService = new StudentServiceImpl(context.getApplicationContext());
        }
        return studentService;
    }
}
