package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Recycleadapter extends RecyclerView.Adapter<Recycleadapter.ViewHolder> {


    private ArrayList<Pokemon> pokearray;
    private Context c;
    private Object LayoutInflater;
    private View
    public Recycleadapter(ArrayList<Pokemon> pokearray, Context c) {
        this.pokearray = pokearray;
        this.c = c;

    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater,from(parent.getContext().inflate(R.Layout));

                return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List payloads) {

        Glide.with(c).asBitmap().load(pokearray.get(position).getImage());
                glide.txtv.setText(pokearray.get(position),getName());
    }

    private Object getName() {
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgv;
        TextView txtv;

        public ViewHolder(@NonNull View itemView) {

            super (itemView);


            imgv = itemView.findViewById(R.id.imgv_poke);
            txtv = itemView.findViewById(R.id.txt_pname);

            itemView.setTag();
            itemView.setOnClickListener();
        }
    }

}
