package com.dreamteam.avengor.model;

import com.dreamteam.avengor.database.Db;

public class AdminModel {

    public static CivilsModel findCivilById(String id){

        return Db.findCivilById(id);


    }
}
