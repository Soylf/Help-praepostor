package com.example.helppraepostor.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helppraepostor.R;
import com.example.helppraepostor.model.ItemStudent;
import com.example.helppraepostor.service.itemstudent.ItemStudentService;
import com.example.helppraepostor.service.itemstudent.ItemStudentServiceImpl;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemStudentPresentAdapter extends RecyclerView.Adapter<ItemStudentPresentAdapter.ViewHolder> {
    private final List<ItemStudent> studentPrecedency;
    private final ItemStudentService service;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemStudent itemStudent = studentPrecedency.get(position);
        holder.name.setText(itemStudent.getName());

        holder.name.setSelected(itemStudent.isSelected());

        holder.name.setOnClickListener(v -> {
            itemStudent.setSelected(!itemStudent.isSelected());
            itemStudent.setPresentStudent(itemStudent.isSelected());
            holder.name.setSelected(itemStudent.isSelected());
        });
        service.updateStudent(itemStudent);
    }

    public void setStudentPrecedency(@NotNull List<ItemStudent> itemStudents) {
        this.studentPrecedency.clear();
        this.studentPrecedency.addAll(itemStudents);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return studentPrecedency.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studentName);
        }
    }
}
