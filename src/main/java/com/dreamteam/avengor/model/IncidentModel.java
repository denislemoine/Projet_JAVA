package com.dreamteam.avengor.model;

import java.sql.*;

public class IncidentModel{
    private int id_Incidents;
    private String Adresse;
    private String TypeIncident;
    private int id_Civils;
    private Integer Ennemis;
    private Integer Mission;
    private String InfoComplementaire;


    // GETTER IncidentModel
    public int getId_Incidents()            {   return id_Incidents;         }
    public String getAdresse()              {   return Adresse;              }
    public String getTypeIncident()         {   return TypeIncident;         }
    public int getId_Civils()               {   return id_Civils;            }
    public Integer getEnnemis()             {   return Ennemis;              }
    public Integer getMission()             {   return Mission;              }
    public String getInfoComplementaire()   {   return InfoComplementaire;   }
    // SETTER IncidentModel
    public void setAdresse(String adresse)                       { Adresse = adresse;            }
    public void setTypeIncident(String typeIncident)             { TypeIncident = typeIncident;  }
    public void setId_Civils(int id_Civils)                      { this.id_Civils = id_Civils;   }
    public void setEnnemis(int ennemis)                          { Ennemis = ennemis;            }
    public void setMission(int mission)                          { Mission = mission;            }
    public void setInfoComplementaire(String infoComplementaire) { InfoComplementaire = infoComplementaire; }

    // CONSTRUCT IncidentModel
    public IncidentModel(
            int id_Incidents
            , String Adresse
            , String TypeIncident
            , int id_Civils
            , Integer Ennemis
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

}
