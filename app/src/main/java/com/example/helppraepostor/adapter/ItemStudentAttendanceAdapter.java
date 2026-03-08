package com.example.helppraepostor.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helppraepostor.R;
import com.example.helppraepostor.model.ItemStudentDto;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemStudentAttendanceAdapter extends RecyclerView.Adapter<ItemStudentAttendanceAdapter.ViewHolder> {
    private List<ItemStudentDto> itemStudentDtos;
    private String itemSelectedDay;

    public void setStudentPrecedency(@NotNull List<ItemStudentDto> itemStudentDtos) {
        this.itemStudentDtos.clear();
        this.itemStudentDtos.addAll(itemStudentDtos);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemStudentAttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Создание формы
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new ItemStudentAttendanceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemStudentAttendanceAdapter.ViewHolder holder, int position) {
        ItemStudentDto student = itemStudentDtos.get(position);
        holder.studentName.setText(student.getName());

        holder.studentName.setSelected(student.isSelected());

        holder.studentName.setOnClickListener(v -> {
            student.setSelected(!student.isSelected());
            holder.studentName.setSelected(student.isSelected());
        });
    }

    @Override
    public int getItemCount() {
        return itemStudentDtos.size();
    }

    public List<ItemStudentDto> getSelectedStudents() {
        List<ItemStudentDto> selected = new ArrayList<>();
        itemStudentDtos.forEach(itemStudent -> {
            if (itemStudent.isSelected()) {
                selected.add(itemStudent);
            }
        });
        return selected;
    }

    static class ViewHolder extends RecyclerView.ViewHolder { //Переиспользования, одного и того же эллемента, чтобы не искать повторно
        TextView studentName;

        ViewHolder(View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.studentName);
        }
    }
}