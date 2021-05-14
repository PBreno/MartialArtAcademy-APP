package com.example.martialartacademy.database.model;

public class UserModel {

    public static final String TABLE_NAME = "tb_usuario";

    public static final String
    COLUMN_ID = "_id",
    COLUMN_USER = "nm_usuario",
    COLUMN_PASSWORD = "ds_senha";

    public static final String CREATE_TABLE =
    "create table "+ TABLE_NAME
    +"("
    + COLUMN_ID + " integer primary key autoincrement, "
    + COLUMN_USER + " text not null, "
    + COLUMN_PASSWORD + " text not null "
    +");";

    public static final String DROP_TABLE =
    " drop table if exists " + TABLE_NAME;

    private long id;
    private String nm_user;
    private String ds_password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNm_user() {
        return nm_user;
    }

    public void setNm_user(String nm_user) {
        this.nm_user = nm_user;
    }

    public String getDs_password() {
        return ds_password;
    }

    public void setDs_password(String ds_password) {
        this.ds_password = ds_password;
    }
}
