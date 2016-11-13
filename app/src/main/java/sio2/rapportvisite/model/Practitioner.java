package sio2.rapportvisite.model;

import java.util.ArrayList;

public class Practitioner {
    private int id;
    private String name;
    private String firstName;
    private String sector;
    private String activity;
    private String activityPrecisions = "";

    public static ArrayList<Practitioner> allPractitioners = new ArrayList<>();

    public Practitioner(int id, String name, String firstName, String sector, String activity, String activityPrecisions){
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.sector = sector;
        this.activity = activity;
        this.activityPrecisions = activityPrecisions;
        allPractitioners.add(this);
    }

    public String getNameFromId(int id){
        for(Practitioner prac : allPractitioners){
            if(prac.id == id)
                return prac.name;
        }
        return "NameNoSuchId";
    }

    public String getFirstNameFromId(int id){
        for(Practitioner prac : allPractitioners){
            if(prac.id == id)
                return prac.firstName;
        }
        return "FirstNameNoSuchId";
    }

    public String getSectorFromId(int id){
        for(Practitioner prac : allPractitioners){
            if(prac.id == id)
                return prac.sector;
        }
        return "SectorNoSuchId";
    }

    public String[] getActivityFromId(int id){
        String[] found = new String[2];
        found[0] = "-1";
        found[1] = "ActivityPrecisionsNoSuchId";
        for(Practitioner prac : allPractitioners){
            if(prac.id == id){
                found[0] = String.valueOf(prac.id);
                found[1] = prac.activityPrecisions;
            }
        }
        return found;
    }
}
