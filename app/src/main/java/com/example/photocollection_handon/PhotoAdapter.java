package com.example.photocollection_handon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private List<Photo> photos;
    private Context context;

    public PhotoAdapter(Context context, List photos){
        this.context = context;
        this.photos = photos;
    }
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        PhotoViewHolder photoViewHolder = new PhotoViewHolder(v);
        return photoViewHolder;
    }


    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
//        holder.itemView.setTag(photos.get(position));
        Photo currentPhoto = this.photos.get( position );

        holder.title.setText(currentPhoto.getTitle());
        holder.datetaken.setText(currentPhoto.getDate_taken());
        holder.thumbnail.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.thumbnail.setImageResource(currentPhoto.getImageUrl());

        //Image
//
//        SimpleDraweeView image = holder.thumbnail;
//        String path = "res://" + currentPhoto.getImageUrl();
//       image.setImageURI(Uri.parse(path));

    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView datetaken;
//        SimpleDraweeView thumbnail;
        ImageView thumbnail;

        public PhotoViewHolder(View itemView) {
            super(itemView);

            this.title = itemView.findViewById(R.id.txttitle);
            this.datetaken = itemView.findViewById(R.id.date_taken);
            this.thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }
    @Override
    public int getItemCount() {
        return this.photos.size();
//        return 0;
    }


}
