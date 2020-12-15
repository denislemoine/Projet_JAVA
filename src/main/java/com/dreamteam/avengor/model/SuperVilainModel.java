package com.dreamteam.avengor.model;

public class SuperVilainModel {
    private int id_SuperVilain;
    private String Nom;
    private int IdentiteSecrete;
    private String Pouvoir;
    private String PointFaible;
    private Float Score;
    private String Commentaire;

    public SuperVilainModel(){

    }

    public SuperVilainModel(int id_SuperVilain,String Nom,int IdentiteSecrete,String Pouvoir,String PointFaible,Float Score,String Commentaire){

        super();
        this.id_SuperVilain = id_SuperVilain;
        this.Nom = Nom;
        this.IdentiteSecrete = IdentiteSecrete;
        this.Pouvoir = Pouvoir;
        this.PointFaible = PointFaible;
        this.Score = Score;
        this.Commentaire = Commentaire;
    }

    public int getId_SuperVilain(){
        return id_SuperVilain;
    }

    public void setId_SuperVilain(int id_SuperVilain){
        this.id_SuperVilain = id_SuperVilain;
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
}
