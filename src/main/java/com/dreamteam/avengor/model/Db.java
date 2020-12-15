package com.dreamteam.avengor.model;

import java.sql.*;

public class Db {


    public static void main(String[] args){

        String url="jdbc:mysql://185.31.40.53:3306/avengor_db";
        String userName="avengor_paul";
        String password ="avengor76";

        try {
            Connection con = DriverManager.getConnection(url,userName,password);
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from TRef");

            while (resultSet.next()){
                System.out.println("id_TRef:" +resultSet.getInt("id_TRef"));
                System.out.println("TypeRef:" +resultSet.getString("TypeRef"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
