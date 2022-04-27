package com.example.simulatorapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.github.mikephil.charting.charts.LineChart;

public class resultRL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_rl);
        //lineChart1 = (LineChart) findViewById(R.id.lineChart);
        Intent intent=getIntent();
        String V=intent.getStringExtra("Voltage");
        String res=intent.getStringExtra("Resistance");
        String I=intent.getStringExtra("Inductance");


        Bundle bundle = new Bundle();

        bundle.putString("Voltage",V);
        bundle.putString("Resistance",res);
        bundle.putString("Inductance",I);

        Button btna = findViewById(R.id.btna);
        Button btnb = findViewById(R.id.btnb);
        Button btnc = findViewById(R.id.btnc);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RlI_T.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RlV_T.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RlAll.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}