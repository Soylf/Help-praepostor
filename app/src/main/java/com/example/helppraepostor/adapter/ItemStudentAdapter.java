package com.example.helppraepostor.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helppraepostor.R;
import com.example.helppraepostor.model.ItemStudent;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemStudentAdapter extends RecyclerView.Adapter<ItemStudentAdapter.ViewHolder> {
    private List<ItemStudent> studentPrecedency;

    public void setStudentPrecedency(@NotNull List<ItemStudent> itemStudents) {
        this.studentPrecedency.clear();
        this.studentPrecedency.addAll(itemStudents);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Создание формы
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemStudent student = studentPrecedency.get(position);
        holder.studentName.setText(student.getName());

        holder.studentName.setSelected(student.isSelected());

        holder.studentName.setOnClickListener(v -> {
            student.setSelected(!student.isSelected());
            holder.studentName.setSelected(student.isSelected());
        });

    }

    @Override
    public int getItemCount() {
        return studentPrecedency.size();
    }

    public List<ItemStudent> getSelectedStudents() {
        List<ItemStudent> selected = new ArrayList<>();
        studentPrecedency.forEach(itemStudent -> {
            if(itemStudent.isSelected()) {
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