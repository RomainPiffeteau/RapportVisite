package sio2.rapportvisite.model;

import java.util.ArrayList;

public class Visitor {
    private int id;
    private String name;
    private String firstName;

    public static ArrayList<Visitor> allVisitors = new ArrayList<>();

    public Visitor(int id, String name, String firstName){
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        allVisitors.add(this);
    }

    public String getNameFromId(int id){
        for(Visitor vis : allVisitors){
            if(vis.id==id)
                return vis.name;
        }
        return "NameNoSuchId";
    }

    public String getFirstNameFromId(int id){
        for(Visitor vis : allVisitors){
            if(vis.id==id)
                return vis.firstName;
        }
        return "FirstNameNoSuchId";
    }
}