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
    COLUMN_ADDRESS = "endereco",
    COLUMN_CEP = "endereco";




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
    + COLUMN_ADDRESS + " text not null,"
    + COLUMN_CEP + " text not null "
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    private String cep;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
