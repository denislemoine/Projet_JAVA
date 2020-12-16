package com.dreamteam.avengor.database;

import com.dreamteam.avengor.model.CivilsModel;

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

            //Si un civil exist déjà
            if(civilsModel.getId_Civil() != 0){
                PreparedStatement statement = con.prepareStatement
                        ("insert to civilsModel () value = (?)");
                statement.setString(1,civilsModel.getNom());
                statement.setInt(2,civilsModel.getId_Civil());
                statement.execute();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
