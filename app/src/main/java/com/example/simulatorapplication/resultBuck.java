package com.example.simulatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;

public class resultBuck extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_buck);
        //lineChart1 = (LineChart) findViewById(R.id.lineChart);
        Intent intent=getIntent();
        String V=intent.getStringExtra("Voltage");
        String res=intent.getStringExtra("Resistance");
        String C=intent.getStringExtra("Capacitance");
        String I=intent.getStringExtra("Inductance");
        String T_on=intent.getStringExtra("On");
        String T_off=intent.getStringExtra("Off");
        String Vc_initial=intent.getStringExtra("Vc_i");
        String Il_initial=intent.getStringExtra("Il_i");
        String T_tot=intent.getStringExtra("Tot");


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

        Button btna = findViewById(R.id.btna);
        Button btnb = findViewById(R.id.btnb);
        Button btnc = findViewById(R.id.btnc);
        Button btnd = findViewById(R.id.btnd);
        Button btne = findViewById(R.id.btne);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BuckVc_T.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BuckVl_T.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BuckIo_T.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BuckIl_T.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), lineChart1.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}