package sio2.rapportvisite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnChx = (Button) findViewById(R.id.btnCnx);
        btnChx.setOnClickListener(observateurClic);
    }

    private View.OnClickListener observateurClic = new View.OnClickListener(){
        @Override
    public void onClick(View v){
            switch (v.getId()){
                case R.id.btnCnx:
                    String log=((EditText)findViewById(R.id.log)).getText().toString();
                    String pwd=((EditText) findViewById(R.id.pwd)).getText().toString();

            }
        }
    }
}
