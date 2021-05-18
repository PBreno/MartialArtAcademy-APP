package com.example.martialartacademy.database.model;

public class MobilityModel {

    public static final String TABLE_NAME = "tb_modalidade";

    public static final String COLUMN_MOBILITY = "modalidade";

    public static final String CREATE_TABLE =
    "create table "+ TABLE_NAME
    +"("
    + COLUMN_MOBILITY + " text not null "
    +");";

    public static final String DROP_TABLE =
    " drop table if exists " + TABLE_NAME;

    private String mobility;

    public String getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }
}
