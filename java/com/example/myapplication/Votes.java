package com.example.myapplication;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class Votes implements Serializable {

    private int id;
    private String titre;
    private String date;
    private String position;
    private String description;




    public Votes(int id, String titre, String date, String position) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.position = position;
        //this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /*public String getDescription() {
        return description;
    }*/


    /*public String getNameForAvatar(){
        return firstname.replace(' ', '-').toLowerCase()+
                "-"+lastname.replace(' ', '-').toLowerCase();
    }*/

    @Override
    public boolean equals(@Nullable Object obj) {
        Votes d= (Votes) obj;
        return id==d.getId();
    }
}

