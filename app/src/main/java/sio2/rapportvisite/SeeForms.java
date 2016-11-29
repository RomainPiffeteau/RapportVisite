package sio2.rapportvisite;
import android.os.Bundle;
import android.widget.Adapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import sio2.rapportvisite.data.Persistence;
import sio2.rapportvisite.model.Visit;
import sio2.rapportvisite.model.listForm;

/**
 * Created by pbouchez on 29/11/2016.
 */
public class SeeForms extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //application du layout à l'activity
        setContentView(R.layout.activity_vue_formulaires);
        try {
            //récupération du contenu de l'importation
            listForm fullList = new listForm();
            fullList.initialize(fullList);
            ArrayList<Visit> visitList = fullList.getVisits();
            String listIdVisit[] = new String[visitList.size()];
            for(int i = 0; i<visitList.size();i++){

                listIdVisit[i] = "Code practicien :"+ String.valueOf(visitList.get(i).getIdPractitioner())+" Code visiteur :"+String.valueOf(visitList.get(i).getIdVisitor());}

            //définition d'un Adapter
            //attribution de l'adapter à la liste
            ListView list = (ListView) findViewById(R.id.listForms);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(SeeForms.this,android.R.layout.simple_list_item_1, listIdVisit);
            list.setAdapter(adapter);
            //définition d'un listener sur la liste
            //list.setOnClickListener(observateurClickItem);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
