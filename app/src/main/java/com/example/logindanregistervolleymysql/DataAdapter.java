package com.example.logindanregistervolleymysql;

import android.provider.ContactsContract;

public class DataAdapter {
    public String id_user;
    public String name;
    public String email;
    public String nohp;
    public String username;
    public String password;
    public String alamat;
    public String gender;
    public String agama;
    public String tgllahir;
    public String url;


    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return  email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNohp() {
        return nohp;
    }
    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getUrl() { return url;   }

    public void setUrl(String url) { this.url = url;
    }
}
