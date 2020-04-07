package com.internship.internproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.viewHolder> {
    Context context;
    ArrayList<ratingModel> dataList;

    public historyAdapter(Context context, ArrayList<ratingModel> list){
        this.context = context;
        dataList = list;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.history_item,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.setHistory_range("Range < " + dataList.get(position).getMin()
                + " - " + dataList.get(position).getMax() + " >");
        holder.setHistory_rated(dataList.get(position).getRated() + "");
        holder.setHistory_dateTime(dataList.get(position).getTimeDate() + "");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView history_range , history_rated , history_dateTime;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            history_range = itemView.findViewById(R.id.historyRange);
            history_rated = itemView.findViewById(R.id.historyRate);
            history_dateTime = itemView.findViewById(R.id.historyTime);
        }

        public void setHistory_range(String history_range) {
            this.history_range.setText(history_range);
        }

        public void setHistory_rated(String history_rated) {
            this.history_rated.setText(history_rated);
        }

        public void setHistory_dateTime(String history_dateTime) {
            this.history_dateTime.setText(history_dateTime);
        }
    }
}
