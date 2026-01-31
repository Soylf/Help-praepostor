package com.example.helppraepostor.service.factory;

import com.example.helppraepostor.service.StudentService;
import com.example.helppraepostor.service.StudentServiceImpl;

public final class ServiceFactory {
    private ServiceFactory() {}

    public static StudentService studentService() {
        return new StudentServiceImpl();
    }

}
