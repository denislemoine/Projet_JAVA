package com.dreamteam.avengor.model;

import java.util.Date;

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
            ,String Adresse
            ,int TypeIncident
            ,int id_Civils
            ,int Ennemis
            ,int Mission
            ,String InfoComplementaire
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
