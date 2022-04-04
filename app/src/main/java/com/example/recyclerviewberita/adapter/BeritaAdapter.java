package com.example.recyclerviewberita.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewberita.DetailBerita;
import com.example.recyclerviewberita.Model.BeritaModel;
import com.example.recyclerviewberita.R;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {

    private List<BeritaModel> listBerita;
    private Context context;

    public BeritaAdapter(List<BeritaModel> listBerita, Context context) {
        this.listBerita = listBerita;
        this.context = context;
    }

    // untuk deklarasi layout item
    @NonNull
    @Override
    public BeritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout,parent,false);
        return new BeritaAdapter.BeritaViewHolder(view);
    }
//     untuk setting view seprti set text button onclick set image dan sebagaianya
    @Override
    public void onBindViewHolder(@NonNull BeritaViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(listBerita.get(position).getImages()).into(holder.imageberita);
    holder.textjudul.setText(listBerita.get(position).getJudul());
    holder.textkategori.setText(listBerita.get(position).getKategori());
    if(listBerita.get(position).getKategori().equalsIgnoreCase("Life Style")){
        holder.textsimbol.setTextColor(ColorStateList.valueOf(Color.RED));
    }else if(listBerita.get(position).getKategori().equalsIgnoreCase("Healty")){
        holder.textsimbol.setTextColor(ColorStateList.valueOf(Color.GREEN));
    }
    holder.textjudul.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailBerita.class);
            intent.putExtra("beritaModel", listBerita.get(position));
            context.startActivity(intent);
        }
    });

    }

    //IMPORTANT : Jumlah looping dari LIST
    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    // kelas view holder yang berguna untuk meginisialisasi kebutuhan didalam item

    public class BeritaViewHolder extends RecyclerView.ViewHolder{

        ImageView imageberita;
        TextView textjudul,textsimbol,textkategori,textdeskripsi;
        CardView cardButton;


        public BeritaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageberita = itemView.findViewById(R.id.imageBerita);
            textjudul = itemView.findViewById(R.id.textjudul);
            cardButton = itemView.findViewById(R.id.cardButton);
            textsimbol = itemView.findViewById(R.id.textsimbol);
            textkategori = itemView.findViewById(R.id.textkategori);
            textdeskripsi = itemView.findViewById(R.id.textDeskripsi);
        }
    }
}
