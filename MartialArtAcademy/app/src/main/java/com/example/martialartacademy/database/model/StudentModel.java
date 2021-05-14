package com.example.martialartacademy.database.model;

public class StudentModel {

    public static final String TABLE_NAME = "tb_aluno";

    public static final String
    COLUMN_ID = "_id",
    COLUMN_NAME = "nome",
    COLUMN_CPF = "cpf",
    COLUMN_GENDER ="genero",
    COLUMN_BIRTH = "data_nascimento",
    COLUMN_EMAIL = "email",
    COLUMN_PHONE = "Celular",
    COLUMN_ADDRESS = "endereco";

    public static final String CREATE_TABLE =
    "create table "+ TABLE_NAME
    +"("
    +COLUMN_ID + " integer primary key autoincrement, "
    +COLUMN_NAME + " text not null, "
    +COLUMN_CPF + " text not null, "
    +COLUMN_GENDER + " text not null, "
    + COLUMN_BIRTH + " text not null, "
    + COLUMN_EMAIL + " text not null, "
    + COLUMN_PHONE + " text not null, "
    + COLUMN_ADDRESS + " text not null"
    +");";

    public  static final String DROP_TABLE =
        "drop table if exists " + TABLE_NAME;

    private long id;
    private String name;
    private String cpf;
    private String gender;
    private String birth;
    private String email;
    private String phone;
    private String address;
}
