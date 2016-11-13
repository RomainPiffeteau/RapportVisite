package sio2.rapportvisite.model;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;

    public static ArrayList<Product> allProducts = new ArrayList<>();

    public Product(int id, String name){
        this.id = id;
        this.name = name;
        allProducts.add(this);
    }

    public String getNameFromId(int id){
        for(Product prod : allProducts){
            if(prod.id == id)
                return prod.name;
        }
        return "NameNoSuchId";
    }
}
