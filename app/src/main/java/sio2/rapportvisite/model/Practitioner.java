package sio2.rapportvisite.model;

import java.util.ArrayList;

public class Practitioner {
    private int id;
    private String name;
    private String firstName;
    private String sector;
    private String activity;
    private String activityPrecisions;

    public static ArrayList<Practitioner> allPractitioners;
    public static void reset(){ allPractitioners = new ArrayList<>(); }

    public Practitioner(int id, String name, String firstName, String sector, String activity, String activityPrecisions){
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.sector = sector;
        this.activity = activity;
        this.activityPrecisions = activityPrecisions;
        allPractitioners.add(this);
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSector() {
        return sector;
    }

    public String getActivity() {
        return activity;
    }

    public String getActivityPrecisions() {
        return activityPrecisions;
    }

    public Practitioner getPractictionner(int id){
        for(Practitioner p : allPractitioners){
            if(p.id == id)
                return p;
        }
        return null;
    }
}
