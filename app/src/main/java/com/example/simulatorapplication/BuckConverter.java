package com.example.simulatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BuckConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buckconverter);

        EditText Volt = (EditText) findViewById(R.id.voltage);
        int V = Integer.parseInt(Volt.getText().toString());

        EditText res = (EditText) findViewById(R.id.resistance);
        int Res = Integer.parseInt(res.getText().toString());

        EditText Cap = (EditText) findViewById(R.id.capacitance);
        int C = Integer.parseInt(Cap.getText().toString());

        EditText Ind = (EditText) findViewById(R.id.inductance);
        int I = Integer.parseInt(Ind.getText().toString());

        EditText On = (EditText) findViewById(R.id.t_on);
        int T_On = Integer.parseInt(On.getText().toString());

        EditText Off = (EditText) findViewById(R.id.t_off);
        int T_Off = Integer.parseInt(Off.getText().toString());

        EditText vc_i = (EditText) findViewById(R.id.vc_initial);
        int Vc_initial = Integer.parseInt(vc_i.getText().toString());

        EditText il_i = (EditText) findViewById(R.id.il_initial);
        int Il_initial = Integer.parseInt(il_i.getText().toString());

        EditText tot = (EditText) findViewById(R.id.t_tot);
        int T_tot = Integer.parseInt(tot.getText().toString());


        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), resultBuck.class);
                startActivity(i);
            }
        });
    }

}