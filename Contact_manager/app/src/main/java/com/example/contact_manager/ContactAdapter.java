package com.example.contact_manager;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView tvName, tvPhone, edit, delete;
        public MyViewHolder(@NonNull View v){
            super(v);
            tvName = v.findViewById(R.id.contact_name);
            tvPhone = v.findViewById(R.id.contact_phone);
            edit = v.findViewById(R.id.edit);
            delete = v.findViewById(R.id.delete);
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
        holder.tvName.setText(currentItem.getName());
        holder.tvPhone.setText(currentItem.getPhone());

        holder.edit.setOnClickListener(v->{
            Intent intent = new Intent(v.getContext(), EditPage.class);
            intent.putExtra("INDEX", position);
            intent.putExtra("EXTRA_NAME", currentItem.getName());
            intent.putExtra("EXTRA_PHONE", currentItem.getPhone());
            v.getContext().startActivity(intent);
        });

        holder.delete.setOnClickListener(v->{
            Intent intent = new Intent(v.getContext(), EditPage.class);
            intent.putExtra("INDEX", position);
            // Remove item from the list
            contactArray.remove(position);

            // Notify RecyclerView about item removed
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, contactArray.size());
            Toast.makeText(v.getContext(), "Deleted successfuly", Toast.LENGTH_SHORT).show();

        });
    }

    //returns size of data
    @Override
    public int getItemCount(){
        return contactArray.size();
    }
}
