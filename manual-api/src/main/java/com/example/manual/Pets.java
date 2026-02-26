package com.example.manual;

public class Pets {
    private String name;
    private String type;
    private String owner;
    private String race;
    private int age;
    private int owner_age;

    public Pets(String name, String type, String owner, String race,int age,int owner_age){
        this.name = name;
        this.type = type;
        this.owner = owner;
        this.race = race;
        this.age = age;
        this.owner_age = owner_age;

    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String getOwner(){
        return owner;
    }

    public String getRace(){
        return race;
    }

    public int getAge(){
        return age;
    }

    public int getOwner_age(){
        return owner_age;
    }






}
