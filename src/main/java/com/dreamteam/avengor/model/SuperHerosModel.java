package com.dreamteam.avengor.model;

public class SuperHerosModel {
    private int id_SuperHeros;
    private String Nom;
    private int IdentiteSecrete;
    private String Pouvoir;
    private String PointFaible;
    private Float Score;
    private String Commentaire;

    public SuperHerosModel(){
        
    }

    public SuperHerosModel(int id_SuperHeros,String Nom,int IdentiteSecrete,String Pouvoir,String PointFaible,Float Score,String Commentaire){

        super();
        this.id_SuperHeros = id_SuperHeros;
        this.Nom = Nom;
        this.IdentiteSecrete = IdentiteSecrete;
        this.Pouvoir = Pouvoir;
        this.PointFaible = PointFaible;
        this.Score = Score;
        this.Commentaire = Commentaire;
    }

    public int getId_SuperHeros(int id_SuperHeros){
        return id_SuperHeros;
    }

    public void setId_SuperHeros(int id_SuperHeros){
        this.id_SuperHeros = id_SuperHeros;
    }

    public String getNom(String Nom){
        return Nom;
    }

    public void setNom(String Nom){
        this.Nom = Nom;
    }

    public int getIdentiteSecrete(int IdentiteSecrete){
        return IdentiteSecrete;
    }

    public void setIdentiteSecrete(int IdentiteSecrete){
        this.IdentiteSecrete = IdentiteSecrete;
    }

    public String getPouvoir(String Pouvoir){
        return Pouvoir;
    }

    public void setPouvoir(String Pouvoir){
        this.Pouvoir = Pouvoir;
    }

    public String getPointFaible(String PointFaible){
        return PointFaible;
    }

    public void setPointFaible(String PointFaible){
        this.PointFaible = PointFaible;
    }

    public float getScore(float Score){
        return Score;
    }

    public void setScore(float Score){
        this.Score = Score;
    }

    public String getCommentaire(String Commentaire){
        return Commentaire;
    }

    public void setCommentaire(String Commentaire){
        this.Commentaire = Commentaire;
    }
}
