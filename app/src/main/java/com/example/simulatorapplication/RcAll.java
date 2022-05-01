package com.example.simulatorapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.util.Log;

        import com.github.mikephil.charting.charts.LineChart;
        import com.github.mikephil.charting.components.XAxis;
        import com.github.mikephil.charting.data.Entry;
        import com.github.mikephil.charting.data.LineData;
        import com.github.mikephil.charting.data.LineDataSet;
        import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

        import java.util.ArrayList;
        import java.util.Map;


public class RcAll extends AppCompatActivity {

    LineChart mpLineChart;
    float v,r,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc_all);
        mpLineChart = (LineChart) findViewById(R.id.lineChart);

        Intent intent=getIntent();
        String V=intent.getStringExtra("Voltage");
        String res=intent.getStringExtra("Resistance");
        String C=intent.getStringExtra("Capacitance");
        v= Float.parseFloat(V);
        r= Float.parseFloat(res);
        c=Float.parseFloat(C);
        //c= (float) (Float.parseFloat(C) * .000001);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "I vs T");
        LineDataSet lineDataSet2 = new LineDataSet(dataValues2(), "V vs T");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);
        lineDataSet1.setColor(Color.RED);
        lineDataSet2.setColor(Color.BLUE);
        lineDataSet1.setDrawCircles(false);
        lineDataSet2.setDrawCircles(false);
        lineDataSet1.setLineWidth(3);
        lineDataSet2.setLineWidth(3);
        XAxis xAxis = mpLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();

    }

    private ArrayList<Entry> dataValues1() {

        ArrayList<Entry> dataVals = new ArrayList<Entry>();

        float I=v/r;
        float dt= (float) .000001;
        for (double t = 0; t <= 100; t += .1) {
            float x = (float) t;
            float powe=((float) (-1)*x)/(r*c);
            double expo=  Math.exp((double) powe);
            dataVals.add(new Entry(x, I*(float)expo));
        }
        return dataVals;
    }
    private ArrayList<Entry> dataValues2() {

        ArrayList<Entry> dataVals = new ArrayList<Entry>();

        float dt= (float) .000001;
        for (double t = 0; t <= 100; t += .1) {
            float x = (float) t;
            float powe=((float) (-1)*x)/(r*c);
            double expo=  Math.exp((double) powe);

            dataVals.add(new Entry(x, v*((float) 1-(float) expo)));
        }
        return dataVals;
    }
}