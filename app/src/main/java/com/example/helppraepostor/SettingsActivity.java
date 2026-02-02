package com.example.helppraepostor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.helppraepostor.adapter.ItemStudentAdapter;
import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.service.ItemStudentService;
import com.example.helppraepostor.service.factory.ItemStudentServiceFactory;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    private ItemStudentService itemStudentService;
    private ItemStudentAdapter itemStudentAdapter;
    private RecyclerView studentsRecycler;
    private RecyclerView AddSettingsStudentsRecyclerId;

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

        ConstraintLayout rootLayout = findViewById(R.id.main);
        ConstraintLayout settingsLayout = findViewById(R.id.settingsLayout);
        Button buttonAddStudentItem = findViewById(R.id.buttonAddStudentItem);
        buttonAddStudentItem.setOnClickListener(v -> {
            TransitionManager.beginDelayedTransition(rootLayout, new AutoTransition());
            if (settingsLayout.getVisibility() == View.VISIBLE) {
                settingsLayout.setVisibility(View.GONE);
            } else {
                settingsLayout.setVisibility(View.VISIBLE);
            }
        });
        itemStudentAdapter = new ItemStudentAdapter(new ArrayList<>());

        studentsRecycler = findViewById(R.id.studentsRecycler);
        studentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        studentsRecycler.setAdapter(itemStudentAdapter);

        AddSettingsStudentsRecyclerId = findViewById(R.id.addSettingsStudentsRecyclerId);
        AddSettingsStudentsRecyclerId.setLayoutManager(new LinearLayoutManager(this));
        AddSettingsStudentsRecyclerId.setAdapter(itemStudentAdapter);

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

    public void goToInfo(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
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
            studentsRecycler.setAdapter(itemStudentAdapter);
        }

        if(!name.getText().toString().isEmpty() && !age.getText().toString().isEmpty()){
            itemStudentService.saveStudent(student);
            Snackbar.make(view, "Студент сохранен", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(0xFF2C2B2A)
                    .setTextColor(0xFFEAEAEA)
                    .show();
        }else {
            Snackbar.make(view,"Вы не ввели имя/возраст студента", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(0xFF2C2B2A)
                    .setTextColor(0xFFEAEAEA)
                    .show();
        }
    }

    public void deleteAll(View view) {
        itemStudentService.deleteStudents();
        Snackbar.make(view,"Все студенты удалены", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(0xFF2C2B2A)
                .setTextColor(0xFFEAEAEA)
                .show();
    }

    public void deleteById(View view) throws InterruptedException {
        List<ItemStudent> studentList = new ArrayList<>();
        if(!itemStudentService.getItemStudents().isEmpty()){
            studentList.addAll(itemStudentAdapter.getSelectedStudents());
            AddSettingsStudentsRecyclerId.setAdapter(itemStudentAdapter);
        }

        studentList.forEach(student -> {
            itemStudentService.deleteStudent(student.getName());
        });
        Snackbar.make(view,"Выбранные студенты удалены", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(0xFF2C2B2A)
                .setTextColor(0xFFEAEAEA)
                .show();
    }
}