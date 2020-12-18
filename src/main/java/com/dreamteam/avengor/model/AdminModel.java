package com.dreamteam.avengor.model;

import com.dreamteam.avengor.database.Db;

public class AdminModel {

    /**
     * @param id
     * @return
     */
    public static CivilsModel findCivilById(String id){

        return Db.findCivilById(id);
    }

    /**
     * @param id
     */
    public static void deleteCivil(String id){
        Db.deleteCivil(id);
    }

    /**
     * @param id
     * @param civil
     */
    public static void modifyCivil(String id, CivilsModel civil){
        Db.modifyCivil(id,civil);
    }

    /**
     * @param id
     * @return
     */
    public static MissionModel findMissionById(String id){

        return Db.findMissionById(id);
    }

    /**
     * @param id
     */
    public static void deleteMission(String id){
        Db.deleteMission(id);
    }

}
