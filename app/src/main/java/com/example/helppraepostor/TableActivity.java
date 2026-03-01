package com.example.helppraepostor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helppraepostor.adapter.TableCalendarAdapter;
import com.example.helppraepostor.model.ItemDay;
import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.service.itemstudent.factory.ItemStudentServiceFactory;
import com.example.helppraepostor.service.tablestudent.CalendarService;
import com.example.helppraepostor.service.tablestudent.factory.CalendarServiceFactory;

import java.util.List;

public class TableActivity extends AppCompatActivity {
    private CalendarService calendarService;
    private List<ItemDay> itemDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calendarService = CalendarServiceFactory.calendarService();

        calendarService.getCurrentMonth();
        calendarService.getCurrentYear();
        itemDays = calendarService.generatedMonth();

        TextView tvMonthAndYear = findViewById(R.id.tvMonthAndYear);
        tvMonthAndYear.setText(calendarService.getMonthAndYear());

        RecyclerView calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        List<ItemStudent> itemStudents;
        calendarRecyclerView.setLayoutManager(new GridLayoutManager(this, 7));
        try {
            itemStudents = ItemStudentServiceFactory.getStudentService(this).getItemStudents();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TableCalendarAdapter adapter = new TableCalendarAdapter(this, itemDays, itemStudents);
        calendarRecyclerView.setAdapter(adapter);

        ImageButton btnPrevMonth = findViewById(R.id.btnPrevMonth);
        btnPrevMonth.setOnClickListener(view -> {
            calendarService.prevMonth();
            calendarService.getCurrentMonth();
            calendarService.getCurrentYear();
            itemDays = calendarService.generatedMonth();
            tvMonthAndYear.setText(calendarService.getMonthAndYear());
            adapter.setDays(itemDays);
        });

        ImageButton btnNextMonth = findViewById(R.id.btnNextMonth);
        btnNextMonth.setOnClickListener(view -> {
            calendarService.nextMonth();
            calendarService.getCurrentMonth();
            calendarService.getCurrentYear();
            itemDays = calendarService.generatedMonth();
            tvMonthAndYear.setText(calendarService.getMonthAndYear());
            adapter.setDays(itemDays);
        });
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToSetting(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void goToInfo(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }
}