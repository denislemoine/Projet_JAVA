package com.dreamteam.avengor.database;

import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.IncidentModel;


import java.sql.*;
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
                PreparedStatement statement = con.prepareStatement
                        ("insert to civilsModel (nom) value = (?), (prenom) value = (?), (civilite) value = (?), (Id_Civil) value = (?), (adresse) value = (?)," +
                                " (email) value = (?), (tel) value = (?), (nationalité) value = (?), (dateDeNaissance) value = (?), (encrytedPassword) value = (?); ");
                statement.setString(1,civilsModel.getNom());
                statement.setString(2,civilsModel.getPrenom());
                statement.setString(3,civilsModel.getCivilite());
                statement.setInt(4,civilsModel.getId_Civil());
                statement.setString(5,civilsModel.getAdresse());
                statement.setString(6,civilsModel.getEmail());
                statement.setString(7,civilsModel.getTel());
                //statement.setDate(8,civilsModel.getDateDeNaissance());
                statement.setString(9,civilsModel.getencrytedPassword());
                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Ajout d'un incident
    public void saveIncident(IncidentModel incidentModel){

        String url="jdbc:mysql://185.31.40.53:3306/avengor_db";
        String userName="avengor_pe";
        String password ="avengor76";

        try {
            Connection con = DriverManager.getConnection(url,userName,password);

            PreparedStatement statement = con.prepareStatement
                        ("insert to Incidents (Adresse,TypeIncident,id_Civils,Ennemis,InfoComplementaire) " +
                                "value = (?,?,?,?,?,?)");
            statement.setString(0,incidentModel.getAdresse());
            statement.setInt(1,incidentModel.getTypeIncident());
            statement.setInt(2,incidentModel.getId_Civils());
            statement.setInt(3,incidentModel.getEnnemis());
            statement.setString(4,incidentModel.getInfoComplementaire());
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
                        resultSet.getString("email"),resultSet.getString("tel"),resultSet.getDate("dateDeNaissance"),null);
                civils.add(civil);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return civils;
    }
}
