package com.example.helppraepostor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helppraepostor.adapter.ItemStudentAdapter;
import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.service.ItemStudentService;
import com.example.helppraepostor.service.factory.ItemStudentServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    private ItemStudentService itemStudentService;
    private ItemStudentAdapter itemStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        itemStudentService = ItemStudentServiceFactory.getStudentService(this);

        RecyclerView studentsRecycler = findViewById(R.id.studentsRecycler);
        itemStudentAdapter = new ItemStudentAdapter(new ArrayList<>());
        studentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        studentsRecycler.setAdapter(itemStudentAdapter);

        List<ItemStudent> students;
        try {
            students = itemStudentService.getItemStudents();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!students.isEmpty()) {
            itemStudentAdapter.setStudentPrecedency(students);
        }
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void saveStudentItem(View view) throws InterruptedException {
        ItemStudent student = new ItemStudent();
        EditText name = findViewById(R.id.editTextNameStudent);
        EditText age = findViewById(R.id.editTextAgeStudent);

        student.setName(name.getText().toString());
        student.setAge(age.getText().toString().trim());

        if(!itemStudentService.getItemStudents().isEmpty()){
            List<ItemStudent> selected = itemStudentAdapter.getSelectedStudents();
            student.setStudentsPrecedency(selected);

            List<ItemStudent> students =
                    itemStudentService.getItemStudents();

            itemStudentAdapter.setStudentPrecedency(students);
        }

        itemStudentService.saveStudent(student);
    }
}