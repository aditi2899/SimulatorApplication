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

        Res = (EditText) findViewById(R.id.resistance);

        Cap = (EditText) findViewById(R.id.capacitance);

        Ind = (EditText) findViewById(R.id.inductance);

        On = (EditText) findViewById(R.id.t_on);

        Off = (EditText) findViewById(R.id.t_off);

        vc_i = (EditText) findViewById(R.id.vc_initial);

        il_i = (EditText) findViewById(R.id.il_initial);

        tot = (EditText) findViewById(R.id.t_tot);

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
                if( V.isEmpty() || res.isEmpty() || C.isEmpty()  || I.isEmpty()  || T_on.isEmpty()  || T_off.isEmpty()  || Vc_initial.isEmpty()  || Il_initial.isEmpty()  || T_tot.isEmpty()){

                    if( V.isEmpty())
                    {
                        Volt.setError( "Required field " );
                    }
                    if( res.isEmpty())
                    {
                        Res.setError( "Required field " );
                    }
                    if( C.isEmpty())
                    {
                        Cap.setError( "Required field " );
                    }
                    if( I.isEmpty())
                    {
                        Ind.setError( "Required field " );
                    }
                    if( T_on.isEmpty())
                    {
                        On.setError( "Required field " );
                    }
                    if( T_off.isEmpty())
                    {
                        Off.setError( "Required field " );
                    }
                    if( Vc_initial.isEmpty())
                    {
                        vc_i.setError( "Required field " );
                    }
                    if( Il_initial.isEmpty())
                    {
                        il_i.setError( "Required field " );
                    }
                    if( T_tot.isEmpty())
                    {
                        tot.setError( "Required field " );
                    }
                }
                else
                {
                    // add result file
//                    Intent i = new Intent(getApplicationContext(), resultBuck.class);
//                    i.putExtras(bundle);
//                    startActivity(i);
                }

            }
        });
    }
//    public static int getMyString(){
//        return V;
//    }

}