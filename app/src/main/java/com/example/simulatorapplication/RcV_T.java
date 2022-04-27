package com.example.simulatorapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import java.lang.Math;
        import com.github.mikephil.charting.charts.LineChart;
        import com.github.mikephil.charting.components.XAxis;
        import com.github.mikephil.charting.data.Entry;
        import com.github.mikephil.charting.data.LineData;
        import com.github.mikephil.charting.data.LineDataSet;
        import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

        import java.util.ArrayList;
        import java.util.Map;


public class RcV_T extends AppCompatActivity {

    LineChart mpLineChart;
    float v,r,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc_vt);
        mpLineChart = (LineChart) findViewById(R.id.lineChart);

        Intent intent=getIntent();
        String V=intent.getStringExtra("Voltage");
        String res=intent.getStringExtra("Resistance");
        String C=intent.getStringExtra("Capacitance");

        v= Float.parseFloat(V);
        r= Float.parseFloat(res);
        c=Float.parseFloat(C);
        //c= (float) (Float.parseFloat(C) * .000001);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "V vs T");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        XAxis xAxis = mpLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();

    }


    private ArrayList<Entry> dataValues1() {

        ArrayList<Entry> dataVals = new ArrayList<Entry>();

        float dt= (float) .000001;
        for (double t = 0; t <= 50; t += .1) {
            float x = (float) t;
            float powe=((float) (-1)*x)/(r*c);
            double expo=  Math.exp((double) powe);

            dataVals.add(new Entry(x, v*((float) 1-(float) expo)));
        }
        return dataVals;
    }
}