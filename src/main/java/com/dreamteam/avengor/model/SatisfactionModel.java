package com.dreamteam.avengor.model;

public class SatisfactionModel {
    private int id_Satisfaction;
    private Integer id_Civil;
    private Integer id_super_vilain;
    private Integer id_Incidents;
    private Integer id_Mission;
    private String satisfactionType;
    private String message;
    private Integer note;
    private String commentaire;

    /**
     * @param id_Satisfaction
     * @param id_Civil
     * @param id_super_vilain
     * @param id_Incidents
     * @param id_Mission
     * @param satisfactionType
     * @param message
     * @param note
     * @param commentaire
     */
    // Contructor de la class "SatisfactionModel"
    public SatisfactionModel(
            int id_Satisfaction
            ,Integer id_Civil
            ,Integer id_super_vilain
            ,Integer id_Incidents
            ,Integer id_Mission
            ,String satisfactionType
            ,String message
            ,Integer note
            ,String commentaire
    ){
        super();
        this.id_Satisfaction = id_Satisfaction;
        this.id_Civil = id_Civil;
        this.id_super_vilain = id_super_vilain;
        this.id_Incidents = id_Incidents;
        this.id_Mission = id_Mission;
        this.satisfactionType = satisfactionType;
        this.message = message;
        this.note = note;
        this.commentaire = commentaire;
    }
    // GETTER et SETTER
    public String getSatisfactionType()                         { return satisfactionType; }
    public void setSatisfactionType(String satisfactionType)    { this.satisfactionType = satisfactionType; }
    public Integer getId_super_vilain()                         { return id_super_vilain; }
    public void setId_super_vilain(Integer id_super_vilain)     { this.id_super_vilain = id_super_vilain; }
    public int getId_Satisfaction()                             { return id_Satisfaction;  }
    public void setId_Satisfaction(int id_Satisfaction)         { this.id_Satisfaction = id_Satisfaction; }
    public Integer getId_Civil()                                { return id_Civil; }
    public void setId_Civil(int id_Civil)                       { this.id_Civil = id_Civil; }
    public Integer getId_Incidents()                            { return id_Incidents; }
    public void setId_Incidents(int id_Incidents)               { this.id_Incidents = id_Incidents; }
    public Integer getId_Mission()                              { return id_Mission; }
    public void setId_Mission(int id_Mission)                   { this.id_Mission = id_Mission; }
    public String getMessage()                                  { return message; }
    public void setMessage(String message)                      { this.message = message; }
    public Integer getNote()                                    { return note; }
    public void setNote(int note)                               { this.note = note; }
    public String getCommentaire()                              { return commentaire; }
    public void setCommentaire(String commentaire)              { this.commentaire = commentaire; }
}
