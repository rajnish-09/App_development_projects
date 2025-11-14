package com.example.to_do_list;

public class Task {
    String name, description;

    public Task(String n, String d){
        name = n;
        description = d;
    }

   public String getName(){
        return name;
   }

   public  String getDescription(){
        return description;
   }

}
