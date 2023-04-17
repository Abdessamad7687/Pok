package com.example.pokemonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.R;
import com.example.pokemonapp.common.Common;
import com.example.pokemonapp.inter.IItemClickListner;
import com.google.android.material.chip.Chip;

import java.util.List;

public class PokemonTypeAdapter extends RecyclerView.Adapter<PokemonTypeAdapter.MyViewHolder> {
    Context context;
    List<String> typeList;

    public PokemonTypeAdapter(Context context, List<String> typeList) {
        this.context = context;
        this.typeList = typeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.chip_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.chip.setChipText(typeList.get(position));
        holder.chip.setBackgroundColor(Common.getColorByType(typeList.get(position)));
        holder.setiItemClickListner(new IItemClickListner() {
            @Override
            public void onClick(View view, int position) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        IItemClickListner iItemClickListner;
        Chip chip;

        public void setiItemClickListner(IItemClickListner iItemClickListner) {
            this.iItemClickListner = iItemClickListner;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            chip =(Chip) itemView.findViewById(R.id.chip);
            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iItemClickListner.onClick(view,getAdapterPosition());
                }
            });
        }
    }
}
