package com.example.martialartacademy.database.model;

import java.math.BigDecimal;

public class PlanModel {

    public static final String TABLE_NAME = "tb_plano";

    public static final String
        COLUMN_MODALITY = "modalidade",
        COLUMN_PLAN = "plano",
        COLUMN_MONTHLYVALUE = "valor_mensal";

    public static final String CREATE_TABLE =
    "create table " + TABLE_NAME
    +"("
    + COLUMN_MODALITY + " text not null ,"
    + COLUMN_PLAN + " text not null ,"
    + COLUMN_MONTHLYVALUE + " decimal, "
    + ");";

    public static final String DROP_TABLE =
    " drop table if exists " + TABLE_NAME;

    private String modality;
    private String plan;
    private BigDecimal monthlyvalue;

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public BigDecimal getMonthlyvalue() {
        return monthlyvalue;
    }

    public void setMonthlyvalue(BigDecimal monthyvalue) {
        this.monthlyvalue = monthyvalue;
    }
}
