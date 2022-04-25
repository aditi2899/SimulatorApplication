package com.example.simulatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BuckConverter extends AppCompatActivity {


    //public static int V;
    EditText Volt, Res,Cap,Ind,On,Off,vc_i,il_i,tot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buckconverter);

        Volt = (EditText) findViewById(R.id.voltage);
        //int V = Integer.parseInt(Volt.getText().toString());

        Res = (EditText) findViewById(R.id.resistance);
//        int Res = Integer.parseInt(res.getText().toString());
//
        Cap = (EditText) findViewById(R.id.capacitance);
//        int C = Integer.parseInt(Cap.getText().toString());
//
        Ind = (EditText) findViewById(R.id.inductance);
//        int I = Integer.parseInt(Ind.getText().toString());
//
        On = (EditText) findViewById(R.id.t_on);
//        int T_On = Integer.parseInt(On.getText().toString());
//
        Off = (EditText) findViewById(R.id.t_off);
//        int T_Off = Integer.parseInt(Off.getText().toString());
//
        vc_i = (EditText) findViewById(R.id.vc_initial);
//        int Vc_initial = Integer.parseInt(vc_i.getText().toString());
//
        il_i = (EditText) findViewById(R.id.il_initial);
//        int Il_initial = Integer.parseInt(il_i.getText().toString());
//
        tot = (EditText) findViewById(R.id.t_tot);
//        int T_tot = Integer.parseInt(tot.getText().toString());


        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String V= Volt.getText().toString();
                String res= Res.getText().toString();
                String C= Cap.getText().toString();
                String I= Ind.getText().toString();
                String T_on= On.getText().toString();
                String T_off= Off.getText().toString();
                String Vc_initial= vc_i.getText().toString();
                String Il_initial= il_i.getText().toString();
                String T_tot= tot.getText().toString();

                Bundle bundle = new Bundle();

                bundle.putString("Voltage",V);
                bundle.putString("Resistance",res);
                bundle.putString("Capacitance",C);
                bundle.putString("Inductance",I);
                bundle.putString("On",T_on);
                bundle.putString("Off",T_off);
                bundle.putString("Vc_i",Vc_initial);
                bundle.putString("Il_i",Il_initial);
                bundle.putString("Tot",T_tot);
                Intent i = new Intent(getApplicationContext(), resultBuck.class);
                i.putExtras(bundle);
                //               i.putExtra("Voltage", V);
                startActivity(i);
            }
        });
    }
//    public static int getMyString(){
//        return V;
//    }

}