package sio2.rapportvisite;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    //Registering static objects
    public static Controller ctrl = new Controller();
    public static TextView appInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        appInfos = (TextView) findViewById(R.id.txtAppInfos);

        //Registering listening buttons
        Button btnFillForm = (Button) findViewById(R.id.btnFillForm);
        btnFillForm.setOnClickListener(clickListener);
        Button btnSeeForms = (Button) findViewById(R.id.btnSeeForms);
        btnSeeForms.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnFillForm:
                    break;
                case R.id.btnSeeForms:
                    break;
            }
        }
    };

    public static void setAppInfos(String str){
        appInfos.setText(str);
        appInfos.setTextColor(Color.GREEN);
    }

    public static void setAppInfosError(String str){
        appInfos.setText(str);
        appInfos.setTextColor(Color.RED);
    }

}
