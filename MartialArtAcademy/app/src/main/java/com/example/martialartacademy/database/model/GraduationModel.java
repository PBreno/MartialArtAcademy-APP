package com.example.martialartacademy.database.model;

public class GraduationModel {

    public static final String TABLE_NAME = "tb_graduacacao";

    public static final String
    COLUMN_MODALITY = "modalidade",
    COLUMN_GRADUATION = "graduacao";

    public static final String CREATE_TABLE =
    "create table " + TABLE_NAME
    +"("
    + COLUMN_MODALITY + " text not null ,"
    + COLUMN_GRADUATION + " text not null"
    + ");";

    public static final String DROP_TABLE =
    " drop table if exists " + TABLE_NAME;

    private String modality;
    private String graduation;

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }
}
