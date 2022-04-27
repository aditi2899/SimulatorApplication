package com.example.simulatorapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.github.mikephil.charting.charts.LineChart;

public class resultRC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_rc);
        //lineChart1 = (LineChart) findViewById(R.id.lineChart);
        Intent intent=getIntent();
        String V=intent.getStringExtra("Voltage");
        String res=intent.getStringExtra("Resistance");
        String C=intent.getStringExtra("Capacitance");


        Bundle bundle = new Bundle();

        bundle.putString("Voltage",V);
        bundle.putString("Resistance",res);
        bundle.putString("Capacitance",C);

        Button btna = findViewById(R.id.btna);
        Button btnb = findViewById(R.id.btnb);
        Button btnc = findViewById(R.id.btnc);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RcI_T.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RcV_T.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RcAll.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}