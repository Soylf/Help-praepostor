package com.example.helppraepostor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helppraepostor.R;
import com.example.helppraepostor.model.ItemDay;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class TableCalendarAdapter extends RecyclerView.Adapter<TableCalendarAdapter.DayViewHolder> {
    private final Context context;
    private List<ItemDay> days;

    private int selectedPosition = -1;

    public TableCalendarAdapter(Context context, List<ItemDay> days) {
        this.context = context;
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
}
