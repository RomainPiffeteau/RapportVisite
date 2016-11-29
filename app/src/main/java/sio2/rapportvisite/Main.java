package sio2.rapportvisite;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

import sio2.rapportvisite.data.Persistence;

public class Main extends AppCompatActivity {

    //Registering static objects
    public static Controller ctrl = new Controller();
    public static TextView appInfos;
    public static boolean dbConnectEstablished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        dbConnectEstablished = false;
        setAppInfos("Loading Database...");
        try {
            Persistence.refreshDB();
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(),
                    "Can't connect to database!",
                    Toast.LENGTH_SHORT).show();
        }

        appInfos = (TextView) findViewById(R.id.txtAppInfos);

        //Registering listening buttons
        Button btnFillForm = (Button) findViewById(R.id.btnCreateForm);
        btnFillForm.setOnClickListener(clickListener);
        Button btnSeeForms = (Button) findViewById(R.id.btnSeeForms);
        btnSeeForms.setOnClickListener(clickListener);
        ImageButton btnRefreshDb = (ImageButton) findViewById(R.id.btnRefreshDb);
        btnRefreshDb.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                /*case R.id.btnCreateForm:
                    if(!dbConnectEstablished){
                        dbConnectionError();
                    }
                    if(dbConnectEstablished){
                        Intent createForm = new Intent(getApplicationContext(),CreateForm.class);
                        startActivity(createForm);
                    }
                    break;*/
                case R.id.btnSeeForms:
                    Intent seeForms = new Intent(getApplicationContext(),SeeForms.class);
                    startActivity(seeForms);
                    if(!dbConnectEstablished){
                        dbConnectionError();
                    }
                    if(dbConnectEstablished){
                    }
                    break;
                case R.id.btnRefreshDb:
                    try {
                        Persistence.refreshDB();
                    } catch (SQLException e) {
                        Toast.makeText(getApplicationContext(),
                                "Can't connect to database!",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    private void dbConnectionError() {
        try {
            Toast.makeText(getApplicationContext(),
                    "The App is not connected to database !\nRetrying...",
                    Toast.LENGTH_SHORT).show();
            Persistence.refreshDB();
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(),
                    "Can't connect to database!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public static void setAppInfos(String str){
        appInfos.setText(str);
        appInfos.setTextColor(Color.GREEN);
    }

    public static void setAppInfosError(String str){
        appInfos.setText(str);
        appInfos.setTextColor(Color.RED);
    }

}
