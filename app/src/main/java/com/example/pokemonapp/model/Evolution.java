package com.example.pokemonapp.model;

public class Evolution {
    private String num;
    private String name;


    public Evolution(String num, String name) {
        this.num = num;
        this.name = name;
    }

    public Evolution() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
