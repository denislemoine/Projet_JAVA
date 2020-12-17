package com.dreamteam.avengor.model;

import com.dreamteam.avengor.database.Db;

import java.util.List;

public class SuperHerosModel {
    private int id_SuperHeros;
    private String Nom;
    private int IdentiteSecrete;
    private String Pouvoir;
    private String PointFaible;
    private Float Score;
    private String Commentaire;

    public SuperHerosModel(int id_SuperHeros,String Nom,int IdentiteSecrete,String Pouvoir,String PointFaible,Float Score,String Commentaire) {
        super();
        this.id_SuperHeros = id_SuperHeros;
        this.Nom = Nom;
        this.IdentiteSecrete = IdentiteSecrete;
        this.Pouvoir = Pouvoir;
        this.PointFaible = PointFaible;
        this.Score = Score;
        this.Commentaire = Commentaire;
    }

    //==================================================================================
    //                               GETTERS & SETTERS
    //==================================================================================

    public int getId_SuperHeros(){
        return id_SuperHeros;
    }

    public void setId_SuperHeros(int id_SuperHeros){
        this.id_SuperHeros = id_SuperHeros;
    }

    public String getNom(){
        return Nom;
    }

    public void setNom(String Nom){
        this.Nom = Nom;
    }

    public int getIdentiteSecrete(){
        return IdentiteSecrete;
    }

    public void setIdentiteSecrete(int IdentiteSecrete){
        this.IdentiteSecrete = IdentiteSecrete;
    }

    public String getPouvoir(){
        return Pouvoir;
    }

    public void setPouvoir(String Pouvoir){
        this.Pouvoir = Pouvoir;
    }

    public String getPointFaible(){
        return PointFaible;
    }

    public void setPointFaible(String PointFaible){
        this.PointFaible = PointFaible;
    }

    public float getScore(){
        return Score;
    }

    public void setScore(float Score){
        this.Score = Score;
    }

    public String getCommentaire(){
        return Commentaire;
    }

    public void setCommentaire(String Commentaire){
        this.Commentaire = Commentaire;
    }

    //==================================================================================
    //                              CALLBACK QUERIES DB
    //==================================================================================

    public static List<SuperHerosModel> getAllHeros(){
        return Db.getAllHero();
    }


}
