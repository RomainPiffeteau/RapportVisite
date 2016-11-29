package sio2.rapportvisite.model;

import java.util.ArrayList;

public class Visit {
    private int idVisitor;
    private int idPractitioner;
    private String date;
    private String previousDate;
    private String comment;
    private ArrayList<Product> visitProducts;

    public static ArrayList<Visit> allVisits;
    public static void reset(){ allVisits = new ArrayList<>(); }

    public Visit(int idVisitor, int idPractitioner, String date, String previousDate, String comment) {
        this.idVisitor = idVisitor;
        this.idPractitioner = idPractitioner;
        this.date = date;
        this.previousDate = previousDate;
        this.comment = comment;
        visitProducts = new ArrayList<>();
    }

    public int getIdPractitioner() {
        return idPractitioner;
    }

    public int getIdVisitor() { return  idVisitor;}

    public String getDate() {
        return date;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public String getComment() {
        return comment;
    }

    public ArrayList<Product> getVisitProducts() {
        return visitProducts;
    }

    public Visit getVisit(int idPractitioner, int idVisitor){
        for(Visit v : allVisits){
            if(v.idPractitioner == idPractitioner && v.idVisitor == idVisitor)
                return v;
        }
        return null;
    }

    public ArrayList<Visit> getAllVisits(){
        return allVisits;
    }
}
