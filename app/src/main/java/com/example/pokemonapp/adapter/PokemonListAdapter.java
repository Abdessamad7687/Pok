package com.example.pokemonapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokemonapp.R;
import com.example.pokemonapp.common.Common;
import com.example.pokemonapp.inter.IItemClickListner;
import com.example.pokemonapp.model.Pokemon;

import java.util.List;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.MyViewHolder> {

    Context context;
    List<Pokemon> pokemonList;

    public PokemonListAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(pokemonList.get(position).getImg()).into(holder.pokemon_image);
        holder.pokemon_name.setText(pokemonList.get(position).getName());
        holder.setiItemClickListner(new IItemClickListner() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(context,"Click at Pokemon"+pokemonList.get(position).getName(),Toast.LENGTH_LONG);
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(Common.KEY_ENABLE_HOME).putExtra("position",position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView pokemon_image;
        TextView pokemon_name;

        IItemClickListner iItemClickListner;

        public void setiItemClickListner(IItemClickListner iItemClickListner) {
            this.iItemClickListner = iItemClickListner;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemon_image = (ImageView) itemView.findViewById(R.id.pokemon_image);
            pokemon_name = (TextView) itemView.findViewById(R.id.txt_pokemon_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            iItemClickListner.onClick(view,getAdapterPosition());
        }
    }
}
