
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


public class BuckIl_T extends AppCompatActivity {

    LineChart mpLineChart;
    float v,r,c,ind,on,off,vc_i,il_i,t_tot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buck_il_t);
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
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Ii vs T");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setLineWidth(4);
        XAxis xAxis = mpLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();
        mpLineChart.getDescription().setEnabled(false);
    }


    private ArrayList<Entry> dataValues1() {

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