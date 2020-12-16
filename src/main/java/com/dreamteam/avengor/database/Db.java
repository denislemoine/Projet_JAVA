package com.dreamteam.avengor.database;

import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.IncidentModel;
import com.dreamteam.avengor.model.SuperHerosModel;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Db {

    String url;
    String userName;
    String password;

    public Db(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public static void saveCivil(CivilsModel civilsModel){

        String url="jdbc:mysql://185.31.40.53:3306/avengor_db";
        String userName="avengor_paul";
        String password ="avengor76";
        try {
            Connection con = DriverManager.getConnection(url,userName,password);

            //creation d'un civils
            if(civilsModel.getId_Civil() != 0){
                Date birth = Date.valueOf(civilsModel.getDateDeNaissance());
                PreparedStatement statement = con.prepareStatement
                        ("INSERT INTO Civils (Nom, Prenom, Civilite, Adresse, Email, Tel, DateDeNaissance, Password, Nationalite) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1,civilsModel.getNom());
                statement.setString(2,civilsModel.getPrenom());
                statement.setString(3,civilsModel.getCivilite());
                statement.setString(4,civilsModel.getAdresse());
                statement.setString(5,civilsModel.getEmail());
                statement.setString(6,civilsModel.getTel());
                statement.setDate(7, birth);
                statement.setString(8,civilsModel.getencrytedPassword());
                statement.setString(9,civilsModel.getNationalite());
                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveHero(SuperHerosModel superHerosModel){

        String url="jdbc:mysql://185.31.40.53:3306/avengor_db";
        String userName="avengor_paul";
        String password ="avengor76";
        try {
            Connection con = DriverManager.getConnection(url,userName,password);

            //creation d'un civils
            if(superHerosModel.getId_SuperHeros() != 0){
                PreparedStatement statement = con.prepareStatement
                        ("INSERT INTO Super-heros (Nom, IdentitéSecretes, Pouvoir, Point-faible, , Commentaire) " +
                                "VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1,superHerosModel.getNom());
                statement.setInt(2,superHerosModel.getIdentiteSecrete());
                statement.setString(3,superHerosModel.getPouvoir());
                statement.setString(4,superHerosModel.getPointFaible());
                statement.setFloat(5,superHerosModel.getScore());
                statement.setString(6,superHerosModel.getCommentaire());
                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Ajout d'un incident
    public static void saveIncident(IncidentModel incidentModel){

        String url="jdbc:mysql://185.31.40.53:3306/avengor_db";
        String userName="avengor_pe";
        String password ="avengor76";

        try {
            Connection con = DriverManager.getConnection(url,userName,password);

            PreparedStatement statement = con.prepareStatement
                        ("INSERT INTO Incidents (Adresse,TypeIncident,id_Civils,Ennemis,InfoComplementaire) " +
                                "VALUES (?,?,?,?,?)");
            statement.setString(1,incidentModel.getAdresse());
            statement.setInt(2,incidentModel.getTypeIncident());
            statement.setInt(3,incidentModel.getId_Civils());
            statement.setInt(4,incidentModel.getEnnemis());
            statement.setString(5,incidentModel.getInfoComplementaire());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<CivilsModel> getAllCivil(){
        String url="jdbc:mysql://185.31.40.53:3306/avengor_db";
        String userName="avengor_paul";
        String password ="avengor76";
        List<CivilsModel> civils = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(url,userName,password);

            //renvoie de tout les civils
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Civils");
            while(resultSet.next()){
                CivilsModel civil = new CivilsModel(resultSet.getInt("id_Civil"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("civilite"),resultSet.getString("adresse"),
                        resultSet.getString("email"),resultSet.getString("tel"),resultSet.getString("dateDeNaissance"),null,resultSet.getString("Nationalite"));
                civils.add(civil);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return civils;
    }
}
