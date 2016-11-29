package sio2.rapportvisite.model;
import sio2.rapportvisite.model.Visit;
import java.util.ArrayList;

/**
 * Created by pbouchez on 29/11/2016.
 */
public class listForm {

    private ArrayList<Visit> visits;

    public listForm(){
        this.visits = new ArrayList<>();
    }
    public void ajouteUneVisite(Visit visit){
        this.visits.add(visit);
    }
    public void initialize(listForm list){
        list.visits=Visit.allVisits;
    }

    public ArrayList<Visit> getVisits(){
        return visits;
    }
}
