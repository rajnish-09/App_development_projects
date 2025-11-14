package com.example.contact_manager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    public ArrayList<Contact> contactArray;

    public ContactAdapter(ArrayList<Contact> contacts){
        contactArray = contacts;
    }

    //define viewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(@NonNull View v){
            super(v);
            tv = v.findViewById(R.id.contact_name);
        }
    }


    //create single row for one item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_recyclerview,parent,false);
        return new MyViewHolder(view);
    }

    //fetches data and uses data to fill view holder layout
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact currentItem = contactArray.get(position);
        holder.tv.setText(currentItem.getName());
    }

    //returns size of data
    @Override
    public int getItemCount(){
        return contactArray.size();
    }
}
