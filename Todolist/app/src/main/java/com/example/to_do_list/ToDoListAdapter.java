package com.example.to_do_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.MyViewHolder> {
    public ArrayList<Task> taskList;

    public ToDoListAdapter(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView task_name, task_description;

        public MyViewHolder(@NonNull View v){
            super(v);
            task_name = v.findViewById(R.id.task_name);
            task_description = v.findViewById(R.id.task_description);
        }
    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recyclerview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    @NonNull
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Task currentItem = taskList.get(position);
        holder.task_name.setText(currentItem.getName());
        holder.task_description.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount(){
        return taskList.size();
    }

}
