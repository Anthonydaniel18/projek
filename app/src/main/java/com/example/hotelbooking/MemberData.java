package com.example.hotelbooking;

public class MemberData {

    String id,nama,email,password,notel;

    public MemberData(String id, String nama, String email, String password, String notel){
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.notel = notel;
    }

    public String getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getNotel(){
        return notel;
    }

}
