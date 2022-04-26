
package com.example.simulatorapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
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


public class BuckIo_T extends AppCompatActivity {

    LineChart mpLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buck_io_t);
        mpLineChart = (LineChart) findViewById(R.id.lineChart);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        XAxis xAxis = mpLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
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
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
//        float V = 10;
//        double Res = 5;
//        double L = 0.2 * .001;
//        double C = 100 * .000001;
//        double Ton = 0.1 * .001;
//        double Toff = 0.1 * .001;
        float v= Float.parseFloat(V);
        float r= Float.parseFloat(res);
        float c= (float) (Float.parseFloat(C) * .000001);
        float ind= (float) (Float.parseFloat(I)* .001);
        float on= (float) (Float.parseFloat(T_on)* .001);
        float off= (float) (Float.parseFloat(T_off)* .001);
        float vc_i= Float.parseFloat(Vc_initial);
        float il_i= Float.parseFloat(Il_initial);
        float t_tot= Float.parseFloat(T_tot);
        dataVals.add(new Entry(0, vc_i));
        float Vl,Il=0,Io,Vc;
        float dt= (float) .000001;
        float last_Vc=vc_i,last_Il=il_i;
//        float last_Vl= ,
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
}