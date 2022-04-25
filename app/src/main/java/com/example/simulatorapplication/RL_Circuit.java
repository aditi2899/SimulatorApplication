
package com.example.simulatorapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class RL_Circuit extends AppCompatActivity {


    //public static int V;
    EditText Volt, Res,Cap,Ind,On,Off,vc_i,il_i,tot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rl_circuit);

        Volt = (EditText) findViewById(R.id.voltage);

        Res = (EditText) findViewById(R.id.resistance);

        Ind = (EditText) findViewById(R.id.inductance);

        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String V= Volt.getText().toString();
                String res= Res.getText().toString();
                String I= Ind.getText().toString();

                Bundle bundle = new Bundle();

                bundle.putString("Voltage",V);
                bundle.putString("Resistance",res);
                bundle.putString("Inductance",I);
                // add result file
//                Intent i = new Intent(getApplicationContext(), resultBuck.class);
//                i.putExtras(bundle);
//                startActivity(i);
            }
        });
    }

}