package com.example.photocollection_handon;

public class Album {

//    private int _id;
    private String imageBackground;
    private String date;
    private String albumName;

    public Album(){}

    public Album(String image, String date, String name){
//        this._id = id;
        this.imageBackground = image;
        this.date = date;
        this.albumName = name;
    }
//
//    public int get_id() {
//        return _id;
//    }
//
//    public void set_id(int _id) {
//        this._id = _id;
//    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
