package com.example.recyclerviewberita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewberita.Model.BeritaModel;
import com.example.recyclerviewberita.adapter.BeritaAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvBerita;
    List<BeritaModel>listBerita = new ArrayList<BeritaModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvBerita = findViewById(R.id.rvberita);
        listBerita.add(new BeritaModel("Orang ini sakti","Life Style","https://footballscoop.com/.image/t_share/MTgwODU1MzY1OTA3MTI5NzA0/jason-brown.png","sakit adalah kunci menuju keabadian"));
        listBerita.add(new BeritaModel("Keajaiban dunia , ini kata putin","Healty","https://cdn-2.tstatic.net/tribunnews/foto/bank/images/20140306_113652_jojon-nova.jpg","bangsa eropa perlu minum tolak angin"));
        listBerita.add(new BeritaModel("Hidup itu ketika kita tidak mati","Food","https://i.ytimg.com/vi/C72oS-dCWUc/maxresdefault.jpg","lakukan apa pun yang kamu tidak bisa"));

        BeritaAdapter adapter = new BeritaAdapter(listBerita, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        rvBerita.setLayoutManager(layoutManager);
        rvBerita.setAdapter(adapter);
    }
}