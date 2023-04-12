package com.example.viikko11kauppalista;

import java.util.ArrayList;

public class productStorage {

    private ArrayList<Product> products = new ArrayList<>();

    private static productStorage statproductstorage = null;

    private productStorage(){
    }


    public static productStorage getInstance(){
        if(statproductstorage == null){
            statproductstorage = new productStorage();
        }
        return statproductstorage;
    }

    public void addProductToList(Product product){
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }


    public Product getProductById(int id){ return products.get(id);}
}
