package com.example.simulatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Map;


public class lineChart1 extends AppCompatActivity {

    LineChart mpLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart1);
        mpLineChart = (LineChart) findViewById(R.id.lineChart);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();

    }


    private ArrayList<Entry> dataValues1() {
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
        Log.d("mesdsage",V);
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
//        float V = 10;
//        double Res = 5;
//        double L = 0.2 * .001;
//        double C = 100 * .000001;
//        double Ton = 0.1 * .001;
//        double Toff = 0.1 * .001;
        float a= Float.parseFloat(V);
        for (double t = .000001; t <= .005; t += .000001) {
            float x = (float) t;
            dataVals.add(new Entry(x, a));
        }
        return dataVals;
    }
}