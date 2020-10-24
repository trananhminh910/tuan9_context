package com.anhminh.ute.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.anhminh.ute.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> Fruits = new ArrayList<>();

    public CustomAdapter(List<String> Fruits, Context context){
        super(context, R.layout.row_contact_item,Fruits);
        this.context = context;
        this.Fruits = Fruits;
}   @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(R.layout.row_contact_item,parent,false);
        TextView FruitName = row.findViewById(R.id.tv_name);
        FruitName.setText(Fruits.get(position));
        return row;
    }

    public void removeItems(List<String> items){
        for(String item : items){
            Fruits.remove(item);
        }
        notifyDataSetChanged();
    }
}
