package com.example.martialartacademy.database.model;

import java.util.Date;

public class EnrollModel {

    public static final String TABLE_NAME = "tb_matricula";

    public static final String
    COLUMN_ENROLL_ID = "_id",
    COLUMN_STUDENT_Id = "codigo_aluno",
    COLUMN_ENROLL_DATE = "data_matricula",
    COLUMN_EXPIRED_DAY = "dia_vencimento",
    COLUMN_CLOSING_DATE = "data_encerrametno";


    public static final String CREATE_TABLE =
    "create table " + TABLE_NAME
    +"("
    + COLUMN_ENROLL_ID + " integer primary key autoincrement, "
    + COLUMN_STUDENT_Id + " integer, "
    + COLUMN_ENROLL_DATE + " date , "
    + COLUMN_EXPIRED_DAY + " integer ,"
    + COLUMN_CLOSING_DATE + " date "
    + ");";

    public static final String DROP_TABLE =
            " drop table if exists " + TABLE_NAME;

    private long id;
    private Integer student_id;
    private Date enroll_date;
    private Integer expired_day;
    private  Date closing_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Date getEnroll_date() {
        return enroll_date;
    }

    public void setEnroll_date(Date enroll_date) {
        this.enroll_date = enroll_date;
    }

    public Integer getExpired_day() {
        return expired_day;
    }

    public void setExpired_day(Integer expired_day) {
        this.expired_day = expired_day;
    }

    public Date getClosing_date() {
        return closing_date;
    }

    public void setClosing_date(Date closing_date) {
        this.closing_date = closing_date;
    }
}
