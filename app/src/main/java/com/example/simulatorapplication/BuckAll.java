
package com.example.simulatorapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;


        import com.github.mikephil.charting.charts.LineChart;
        import com.github.mikephil.charting.components.LimitLine;
        import com.github.mikephil.charting.components.XAxis;
        import com.github.mikephil.charting.components.YAxis;
        import com.github.mikephil.charting.data.Entry;
        import com.github.mikephil.charting.data.LineData;
        import com.github.mikephil.charting.data.LineDataSet;
        import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
        import com.github.mikephil.charting.utils.ColorTemplate;

        import java.util.ArrayList;
        import java.util.Map;


public class BuckAll<VerticalTextView> extends AppCompatActivity {

    LineChart mpLineChart;
    float v,r,c,ind,on,off,vc_i,il_i,t_tot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buck_all);
        mpLineChart = (LineChart) findViewById(R.id.lineChart);

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

        v= Float.parseFloat(V);
        r= Float.parseFloat(res);
        c= (float) (Float.parseFloat(C) * .000001);
        ind= (float) (Float.parseFloat(I)* .001);
        on= (float) (Float.parseFloat(T_on)* .001);
        off= (float) (Float.parseFloat(T_off)* .001);
        vc_i= Float.parseFloat(Vc_initial);
        il_i= Float.parseFloat(Il_initial);
        t_tot= Float.parseFloat(T_tot);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Vc vs T");
        LineDataSet lineDataSet2 = new LineDataSet(dataValues2(), "Vi vs T");
        LineDataSet lineDataSet3 = new LineDataSet(dataValues3(), "Io vs T");
        LineDataSet lineDataSet4 = new LineDataSet(dataValues4(), "Ii vs T");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);
        dataSets.add(lineDataSet3);
        dataSets.add(lineDataSet4);
//        LineDataSet lineDataSet1 = new LineDataSet(yVals1, "ex1");
//        lineDataSet1.setColors(ColorTemplate.PASTEL_COLORS);
//        lineDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
//        getResources().getColor(1234);
//        ((LineDataSet) dataSets.get(1)).setColors(ColorTemplate.VORDIPLOM_COLORS);
//        ((LineDataSet) dataSets.get(1)).setCircleColors(ColorTemplate.VORDIPLOM_COLORS);
        lineDataSet1.setDrawCircles(false);
        lineDataSet2.setDrawCircles(false);
        lineDataSet3.setDrawCircles(false);
        lineDataSet4.setDrawCircles(false);
        lineDataSet1.setLineWidth(3);
        lineDataSet2.setLineWidth(3);
        lineDataSet3.setLineWidth(3);
        lineDataSet4.setLineWidth(3);
//        ((LineDataSet) dataSets.get(0)).enableDashedLine(10, 10, 0);
//        ((LineDataSet) dataSets.get(0)).setColors(ColorTemplate.PASTEL_COLORS);
//        ((LineDataSet) dataSets.get(1)).setColors(ColorTemplate.PASTEL_COLORS);
        lineDataSet1.setColor(Color.GREEN);
        lineDataSet1.setCircleColor(Color.GREEN);
        lineDataSet2.setColor(Color.BLUE);
        lineDataSet2.setCircleColor(Color.BLUE);
        lineDataSet3.setColor(Color.BLACK);
        lineDataSet3.setCircleColor(Color.BLACK);
        lineDataSet4.setColor(Color.RED);
        lineDataSet4.setCircleColor(Color.RED);
        XAxis xAxis = mpLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.enableGridDashedLine(1,1,0);
//        xAxis.setTypeface(t);
//        xAxis.setDrawLabels(true);
//        xAxis.setDrawGridLines(false);
        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();
        mpLineChart.getDescription().setEnabled(false);
    }

    private ArrayList<Entry> dataValues1() {

        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, vc_i));
        float Vl,Il=0,Io,Vc;
        float dt= (float) .000001;
        float last_Vc=vc_i,last_Il=il_i;
        for (double t = .000001; t <= t_tot; t += .000001) {
            float x = (float) t;
            float modu = x%(on+off);

            if(modu<=on){
                Vl=v-last_Vc;
            }
            else{
                Vl=-last_Vc;
            }
            Il=last_Il+((Vl*dt)/ind);
            Io=last_Vc/r;
            Vc=last_Vc+((Il-last_Vc/r)*dt/c);
            dataVals.add(new Entry(x, Vc));
            last_Vc=Vc;
            last_Il=Il;
        }
        return dataVals;
    }
    private ArrayList<Entry> dataValues2() {

        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, vc_i));
        float Vl,Il=0,Io,Vc;
        float dt= (float) .000001;
        float last_Vc=vc_i,last_Il=il_i;
        for (double t = .000001; t <= t_tot; t += .000001) {
            float x = (float) t;
            float modu = x%(on+off);


            if(modu<=on){
                Vl=v-last_Vc;
            }
            else{
                Vl=-last_Vc;
            }
            Il=last_Il+((Vl*dt)/ind);
            Io=last_Vc/r;
            Vc=last_Vc+((Il-last_Vc/r)*dt/c);
            dataVals.add(new Entry(x, Vl));
            last_Vc=Vc;
            last_Il=Il;
        }
        return dataVals;
    }
    private ArrayList<Entry> dataValues3() {

        ArrayList<Entry> dataVals = new ArrayList<Entry>();

        dataVals.add(new Entry(0, 0));
        float Vl,Il=0,Io,Vc;
        float dt= (float) .000001;
        float last_Vc=vc_i,last_Il=il_i;
        for (double t = .000001; t <= t_tot; t += .000001) {
            float x = (float) t;
            float modu = x%(on+off);

            if(modu<=on){
                Vl=v-last_Vc;
            }
            else{
                Vl=-last_Vc;
            }
            Il=last_Il+((Vl*dt)/ind);
            Io=last_Vc/r;
            Vc=last_Vc+((Il-last_Vc/r)*dt/c);
            dataVals.add(new Entry(x, Io));
            last_Vc=Vc;
            last_Il=Il;
        }
        return dataVals;
    }
    private ArrayList<Entry> dataValues4() {

        ArrayList<Entry> dataVals = new ArrayList<Entry>();

        dataVals.add(new Entry(0, il_i));
        float Vl,Il=0,Io,Vc;
        float dt= (float) .000001;
        float last_Vc=vc_i,last_Il=il_i;
        for (double t = .000001; t <= t_tot; t += .000001) {
            float x = (float) t;
            float modu = x%(on+off);

            if(modu<=on){
                Vl=v-last_Vc;
            }
            else{
                Vl=-last_Vc;
            }
            Il=last_Il+((Vl*dt)/ind);
            Io=last_Vc/r;
            Vc=last_Vc+((Il-last_Vc/r)*dt/c);
            dataVals.add(new Entry(x, Il));
            last_Vc=Vc;
            last_Il=Il;
        }
        return dataVals;
    }
}