package sio2.rapportvisite.model;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;

    public static ArrayList<Product> allProducts;
    public static void reset(){ allProducts = new ArrayList<>(); }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
        allProducts.add(this);
    }

    public String getName() {
        return name;
    }

    public Product getProduct(int id){
        for(Product p : allProducts){
            if(p.id == id)
                return p;
        }
        return null;
    }
}
