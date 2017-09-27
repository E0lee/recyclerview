package com.example.lee.myapplication;

import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lee on 2016/5/23.
 */
public class item {
    private String artist, title,content;
    private Calendar calendar;
    private boolean star,read;
    private static String[] ArtistList={"honda","yamaha","mazda","toyota"};
    private static String[] titleList={"this is a Yaaaaaaaaaaaaaaaaaa","id.widget.GridLayout: horizontal constraints: x2-","ee.myapplication D/android.widget.Gri","rmanently removing: x2-x0<=1"};
    private static String[] contentList={"05-23 01:31:18.498 1861-1861/com.example.lee.myapplication D/android.widget.GridLayout: horizontal constraints: x2-x0>=704, x1-x0>=131, x2-x0<=131 are inconsistent; permanently removing: x2-x0<=131. ",
            "Failed to find OatDexFile for DexFile /data/data/com.example.lee.myapplication/files/instant-run/dex/slice-slice_2-classes.dex ( canonical path /data/da",
            "861/com.example.lee.myapplication I/art: Late-enabling -Xcheck:jni",
            "Before Android 4.1, method android.graphics.PorterDuffColorFilter android.support.graphics.drawabl"};
    public item(){}
    public String getArtist(){
        return  artist;
    }
    public String getTitle(){
        return  title;
    }
    public String getContent(){
        return  content;
    }
    public boolean getStar(){
        return  star;
    }
    public boolean getRead(){
        return  read;
    }
    public Calendar getCalendar(){
        return  calendar;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setStar(boolean star){
        this.star = star;
    }
    public void setRead(boolean read){
        this.read = read;
    }
    public void setCalendar(Calendar calendar){
        this.calendar = calendar;
    }
    public static List<item> generateSampleList(){
        List<item> list = new ArrayList<>();
        for(int i=0; i < 30; i++){
            item item = new item();
            item.setArtist(ArtistList[(int) (Math.random()*4)]);
            item.setTitle(titleList[(int) (Math.random()*4)]);
            item.setContent(contentList[(int) (Math.random()*4)]);
            item.setStar((int)(Math.random()*2)>0?true:false);
            item.setRead((int)(Math.random()*2)>0?true:false);
            item.setCalendar(Calendar.getInstance());
            list.add(item);
        }
        return list;
    }
    public static List<item> generateSampleList(List<item> list){
        list = new ArrayList<>();
        for(int i=0; i < 10; i++){
            item item = new item();
            item.setArtist(ArtistList[(int) (Math.random()*4)]);
            item.setTitle(titleList[(int) (Math.random()*4)]);
            item.setContent(contentList[(int) (Math.random()*4)]);
            item.setStar((int)(Math.random()*2)>0?true:false);
            item.setRead((int)(Math.random()*2)>0?true:false);
            item.setCalendar(Calendar.getInstance());
            list.add(item);
        }
        return list;
    }
}
