package com.dreamteam.avengor.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class CivilController {

private int id_Civil;
private String Nom;
private String Prenom;
private String Civilite;
private String Adresse;
private String Email;
private String Tel;
private String Nationalité;
private Date DateDeNaissance;
private String encrytedMotDePasse;

    public CivilController() {

    }

    public CivilController(int id_Civil,String Nom,String Prenom,String Civilite,String Adresse,String Email,String Tel,//
                           Date DateDeNaissance, String encrytedMotDePasse){
        super();
        this.id_Civil = id_Civil;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Civilite = Civilite;
        this.Adresse = Adresse;
        this.Email = Email;
        this.Tel = Tel;
        this.DateDeNaissance = DateDeNaissance;
        this.encrytedMotDePasse = encrytedMotDePasse;
    }

    public int getId_Civil(int id_Civil){
        return id_Civil;
    }

    public void setId_Civil(int id_Civil){
        this.id_Civil = id_Civil;
    }

    public String getNom(String Nom){
        return Nom;
    }

    public void setNom(String Nom){
        this.Nom = Nom;
    }

    public String getPrenom(String Prenom){
        return Prenom;
    }

    public void setPrenom(String Prenom){
        this.Prenom = Prenom;
    }

    public String getCivilite(String Civilite){
        return Civilite;
    }

    public void setCivilite(String Civilite){
        this.Civilite = Civilite;
    }

    public String getAdresse(String Adresse){
        return Adresse;
    }

    public void setAdresse(String Adresse){
        this.Adresse = Adresse;
    }

    public String getEmail(String Email){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getTel(String Tel){
        return Tel;
    }

    public void setTel(String Tel){
        this.Tel = Tel;
    }
    public Date getDateDeNaissance(Date DateDeNaissance){
        return DateDeNaissance;
    }

    public void setDateDeNaissance(Date DateDeNaissance){
        this.DateDeNaissance = DateDeNaissance;
    }

    public String getencrytedMotDePasse(String encrytedMotDePasse){
        return encrytedMotDePasse;
    }

    public void setencrytedMotDePasse(String encrytedMotDePasse){
        this.encrytedMotDePasse = encrytedMotDePasse;
    }
}