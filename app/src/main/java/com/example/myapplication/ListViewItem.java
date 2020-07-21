package com.example.myapplication;
import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String writerStr;
    private String dateStr;
    private String artistStr;
    private String genreStr;
    private String uriStr;

    public void setIcon(Drawable icon){
        iconDrawable = icon;
    }
    public void setTitle(String title){
        titleStr = title;
    }
    public void setWriter(String writer){writerStr = writer;}
    public void setDate(String date){dateStr = date; }
    public void setArtist(String artist){artistStr = artist; }
    public void setGenre(String genre){genreStr = genre;}
    public void setUriStr(String uri) {uriStr = uriStr; }

    public Drawable getIcon(){
        return this.iconDrawable;
    }
    public String getTitle(){
        return this.titleStr;
    }
    public String getWriter(){ return this.writerStr; }
    public String getDate(){ return this.dateStr; }
    public String getArtist(){ return this.artistStr; }
    public String getGenre(){ return this.genreStr; }
    public String getUri(){return this.uriStr; }


    public void setData(Drawable ic, String title, String writer, String date, String artist, String genre, String uri){
        iconDrawable = ic;
        titleStr = title;
        writerStr = writer;
        dateStr = date;
        artistStr = artist;
        genreStr = genre;
        uriStr = uri;
    }
}
