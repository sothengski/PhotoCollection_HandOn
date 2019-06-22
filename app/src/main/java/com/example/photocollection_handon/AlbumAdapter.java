package com.example.photocollection_handon;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private ArrayList<Album> albums = new ArrayList<>();
    private Context mContext;

    public AlbumAdapter(ArrayList<Album> albums, Context mContext) {
        this.albums = albums;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
//        final int poisition = i;

        viewHolder.album_name.setText(albums.get(i).getAlbumName());


        viewHolder.album_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tag:", albums.get(i).getAlbumName());
                Intent photoActivity = new Intent(mContext, PhotoActivity.class);
                mContext.startActivity(photoActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView album_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            album_name = itemView.findViewById(R.id.albumtitle);
        }
    }
}
