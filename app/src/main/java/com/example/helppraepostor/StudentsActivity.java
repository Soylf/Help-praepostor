package com.example.helppraepostor;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helppraepostor.adapter.ItemStudentAdapter;
import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.service.itemstudent.ItemStudentService;
import com.example.helppraepostor.service.itemstudent.factory.ItemStudentServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_students);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ItemStudentService studentService = ItemStudentServiceFactory.getStudentService(this);

        RecyclerView recyclerView = findViewById(R.id.allStudents);
        ItemStudentAdapter itemStudentAdapter = new ItemStudentAdapter(new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            itemStudentAdapter.setStudentPrecedency(studentService.getItemStudents());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        recyclerView.setAdapter(itemStudentAdapter);
    }
}