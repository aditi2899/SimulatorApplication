
package com.example.simulatorapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class RL_Circuit extends AppCompatActivity {

    EditText Volt, Res,Ind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rl_circuit);

        Volt = (EditText) findViewById(R.id.voltage);

        Res = (EditText) findViewById(R.id.resistance);

        Ind = (EditText) findViewById(R.id.inductance);
        Button btnknow= findViewById(R.id.knowMoreRL);
        btnknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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
                if( V.isEmpty() || res.isEmpty() || I.isEmpty()){

                    if( V.isEmpty())
                    {
                        Volt.setError( "Required field " );
                    }
                    if( res.isEmpty())
                    {
                        Res.setError( "Required field " );
                    }
                    if( I.isEmpty())
                    {
                        Ind.setError( "Required field " );
                    }
                }
                else
                {
                    //add result file
//                    Intent i = new Intent(getApplicationContext(), resultBuck.class);
//                    i.putExtras(bundle);
//                    startActivity(i);
                }
            }
        });
    }

}