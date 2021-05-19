package com.example.martialartacademy.database.model;

import java.sql.Date;

public class ModalityEnrollModel {

    public static final String TABLE_NAME = "tb_matricula_modalidade";

    public static final String
            COLUMN_ID = "_id",
            COLUMN_MODALITY = "modalidade",
            COLUMN_GRADUATION = "graduacao",
            COLUMN_BEGIN_DATE ="data_inicio",
            COLUMN_END_DATE = "data_fim",
            COLUMN_PLAN = "plan";

    public static final String CREATE_TABLE =
    "create table "+ TABLE_NAME
    +"("
    +COLUMN_ID + " integer primary key autoincrement, "
    +COLUMN_MODALITY + " text not null, "
    +COLUMN_GRADUATION + " text not null, "
    +COLUMN_BEGIN_DATE + " text not null, "
    + COLUMN_END_DATE + " text not null, "
    + COLUMN_PLAN + " text not null "
    +");";

    public  static final String DROP_TABLE =
            "drop table if exists " + TABLE_NAME;

    private long id;
    private String modality;
    private String graduation;
    private Date begin_date;
    private  Date end_date;
    private String plan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
