package com.example.helppraepostor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helppraepostor.R;
import com.example.helppraepostor.model.ItemDay;
import com.example.helppraepostor.model.ItemStudent;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class TableCalendarAdapter extends RecyclerView.Adapter<TableCalendarAdapter.DayViewHolder> {
    private final Context context;
    private final List<ItemStudent> itemStudents;
    private List<ItemDay> days;

    private int selectedPosition = -1;

    public TableCalendarAdapter(Context context, List<ItemDay> days, List<ItemStudent> itemStudents) {
        this.context = context;
        this.itemStudents = itemStudents;
        this.days = days;
    }

    @NonNull
    @Override
    public TableCalendarAdapter.DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_day, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableCalendarAdapter.DayViewHolder holder, int position) {
        ItemDay itemDay = days.get(position);
        holder.tvDay.setText(String.valueOf(itemDay.getDay()));

        holder.itemView.setSelected(position == selectedPosition);

        holder.itemView.setOnClickListener(v -> {
            int oldPosition = selectedPosition;
            selectedPosition = holder.getAdapterPosition();

            notifyItemChanged(oldPosition);
            notifyItemChanged(selectedPosition);

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
            View sheetView = LayoutInflater.from(context)
                    .inflate(R.layout.dialog_day_info, null);
            bottomSheetDialog.setContentView(sheetView);

            View bottomSheet = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if(bottomSheet != null){
                BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
                bottomSheetBehavior.setDraggable(false);//Убираем свайп вниз
            }

            ConstraintLayout constraintLayoutAttendanceDay = sheetView.findViewById(R.id.ConstraintLayoutAttendanceDay);
            ImageButton btnAllStudent = sheetView.findViewById(R.id.btnAllStudent);
            visibilityOrGoneAttendanceDay(btnAllStudent, constraintLayoutAttendanceDay);

            RecyclerView recyclerViewAttendanceDay = sheetView.findViewById(R.id.RecyclerViewAttendanceDay);
            recyclerViewAttendanceDay.setLayoutManager(new LinearLayoutManager(context));
            ItemStudentAttendanceAdapter itemStudentAttendanceAdapter = new ItemStudentAttendanceAdapter(itemStudents);
            recyclerViewAttendanceDay.setAdapter(itemStudentAttendanceAdapter);

            bottomSheetDialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public void setDays(List<ItemDay> newDays) {
        this.days = newDays;
        notifyDataSetChanged();
    }

    static class DayViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay;
        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tvDay);
        }
    }

    private void visibilityOrGoneAttendanceDay(ImageButton btnToggle , ConstraintLayout constraintLayoutAttendanceDay) {
        btnToggle.setOnClickListener(v -> {
            if(constraintLayoutAttendanceDay.getVisibility() == View.VISIBLE){
                constraintLayoutAttendanceDay.setVisibility(View.GONE);
            } else {
                constraintLayoutAttendanceDay.setVisibility(View.VISIBLE);
            }
        });
    }
}
