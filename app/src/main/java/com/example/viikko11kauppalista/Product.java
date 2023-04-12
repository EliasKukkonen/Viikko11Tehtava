package com.example.viikko11kauppalista;

public class Product {

    private String ostos;
    private String Muistiinpanot;

    protected int id;

    private static int idCounter = 0;




    public Product(String ostos, String Muistiinpanot){
        this.ostos=ostos;
        this.Muistiinpanot=Muistiinpanot;
        this.id = ++idCounter;

    }


    public String getOstos(){
        return ostos;
    }

    public String getMuistiinpanot(){
        return Muistiinpanot;
    }


    public int getId(){
        return id;
    }


    public void setMuistiinpanot(String Muistiinpanot){
        this.Muistiinpanot=Muistiinpanot;
    }

}



