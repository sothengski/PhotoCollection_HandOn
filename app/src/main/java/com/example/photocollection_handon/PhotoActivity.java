package com.example.photocollection_handon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PhotoActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Photo> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        recyclerView = findViewById(R.id.photos_recyclerview);
        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();

        initializeData();
//        listItems.add(new Photo("1","11/11/11"));
        adapter = new PhotoAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }
    private void initializeData(){
//        listItems = new ArrayList<>();
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"11/11/11"));
        listItems.add(new Photo("2", R.drawable.qr,"12/12/12"));
        listItems.add(new Photo("3", R.drawable.original,"01/01/01"));
//        listItems.add(new Photo("1", R.drawable.web_portal,"02/02/02"));
    }

}
