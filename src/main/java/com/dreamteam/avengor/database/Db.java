package com.dreamteam.avengor.database;

import com.dreamteam.avengor.model.CivilsModel;
import com.dreamteam.avengor.model.IncidentModel;


import java.sql.*;

public class Db {

    String url;
    String userName;
    String password;

    public Db(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public void saveCivil(CivilsModel civilsModel){

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

            //Si un civil exist déjà
            if(incidentModel.getId_Incidents() != 0){
                PreparedStatement statement = con.prepareStatement
                        ("insert to Incidents () value = (?)");
                statement.setString(1,incidentModel.getAdresse());
                statement.setInt(2,incidentModel.getTypeIncident());
                statement.setInt(3,incidentModel.getId_Civils());
                statement.setInt(4,incidentModel.getEnnemis());
                statement.setInt(5,incidentModel.getMission());
                statement.setString(6,incidentModel.getInfoComplementaire());
                statement.execute();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
