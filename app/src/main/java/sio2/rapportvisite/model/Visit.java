package sio2.rapportvisite.model;

import java.util.ArrayList;

public class Visit {
    private int id;
    private int idVisitor;
    private int idLastVisitor;
    private int idPractitioner;
    private String date;
    private String previousDate;
    private String visitComments;

    public static ArrayList<Visit> allVisits = new ArrayList<>();

    public Visit(String visitComments, int id, int idVisitor, int idLastVisitor, int idPractitioner, String date, String previousDate) {
        this.visitComments = visitComments;
        this.id = id;
        this.idVisitor = idVisitor;
        this.idLastVisitor = idLastVisitor;
        this.idPractitioner = idPractitioner;
        this.date = date;
        this.previousDate = previousDate;
        allVisits.add(this);
    }

    public int getIdVisitor(){
        return this.idVisitor;
    }

    public int getIdLastVisitor() {
        return idLastVisitor;
    }

    public int getIdPractitioner() {
        return idPractitioner;
    }

    public String getDate() {
        return date;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public String getVisitComments() {
        return visitComments;
    }
}
