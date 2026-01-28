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
import com.example.helppraepostor.service.StudentService;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SettingsActivity extends AppCompatActivity {
    private StudentService studentService;
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

        RecyclerView studentsRecycler =
                findViewById(R.id.studentsRecycler);
        List<ItemStudent> students =
                studentService.getItemStudents();

        itemStudentAdapter =
                new ItemStudentAdapter(students);
        studentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        studentsRecycler.setAdapter(itemStudentAdapter);
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void saveStudentItem(View view) {
        ItemStudent student = new ItemStudent();
        EditText name = findViewById(R.id.editTextNameStudent);
        EditText age = findViewById(R.id.editTextAgeStudent);

        student.setName(name.getText().toString());
        student.setAge(age.getText().toString().trim());

        List<ItemStudent> selected = itemStudentAdapter.getSelectedStudents();

        student.setStudentsPrecedency(selected);

        studentService.saveStudent(student);

        List<ItemStudent> students =
                studentService.getItemStudents();
        itemStudentAdapter.setStudentPrecedency(students);
    }
}