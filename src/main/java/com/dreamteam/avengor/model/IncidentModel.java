package com.dreamteam.avengor.model;

import java.sql.*;

public class IncidentModel{
    private int id_Incidents;
    private String Adresse;
    private int TypeIncident;
    private int id_Civils;
    private int Ennemis;
    private int Mission;
    private String InfoComplementaire;


    // GETTER IncidentModel
    public int getId_Incidents()            {   return id_Incidents;         }
    public String getAdresse()              {   return Adresse;              }
    public int getTypeIncident()            {   return TypeIncident;         }
    public int getId_Civils()               {   return id_Civils;            }
    public int getEnnemis()                 {   return Ennemis;              }
    public int getMission()                 {   return Mission;              }
    public String getInfoComplementaire()   {   return InfoComplementaire;   }
    // SETTER IncidentModel
    public void setAdresse(String adresse)                       { Adresse = adresse;            }
    public void setTypeIncident(int typeIncident)                { TypeIncident = typeIncident;  }
    public void setId_Civils(int id_Civils)                      { this.id_Civils = id_Civils;   }
    public void setEnnemis(int ennemis)                          { Ennemis = ennemis;            }
    public void setMission(int mission)                          { Mission = mission;            }
    public void setInfoComplementaire(String infoComplementaire) { InfoComplementaire = infoComplementaire; }

    // CONSTRUCT IncidentModel
    public IncidentModel(
            int id_Incidents
            , String Adresse
            , int TypeIncident
            , int id_Civils
            , int Ennemis
            , Integer Mission
            , String InfoComplementaire
    ){
        this.id_Incidents = id_Incidents;
        this.Adresse = Adresse;
        this.TypeIncident = TypeIncident;
        this.id_Civils = id_Civils;
        this.Ennemis = Ennemis;
        this.Mission = Mission;
        this.InfoComplementaire = InfoComplementaire;
    }

    public static int getLastId(){
        String url="jdbc:mysql://185.31.40.53:3306/avengor_db";
        String userName="avengor_pe";
        String password ="avengor76";
        try {
            Connection con = DriverManager.getConnection(url,userName,password);

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select MAX(id_Incidents) as LastID from Incidents");
            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
