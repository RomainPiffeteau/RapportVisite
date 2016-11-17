package sio2.rapportvisite.model;

import java.util.ArrayList;

public class Visitor {
    private int id;
    private String name;
    private String firstName;

    public static ArrayList<Visitor> allVisitors;
    public static void reset(){ allVisitors = new ArrayList<>(); }

    public Visitor(int id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        allVisitors.add(this);
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public Visitor getVisitor(int id){
        for(Visitor v : allVisitors){
            if(v.id == id)
                return v;
        }
        return null;
    }
}