
package com.example.simulatorapplication;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class RC_Circuit extends AppCompatActivity {

    EditText Volt, Res,Cap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc_circuit);

        Volt = (EditText) findViewById(R.id.voltage);

        Res = (EditText) findViewById(R.id.resistance);

        Cap = (EditText) findViewById(R.id.capacitance);
        Button btnknow= findViewById(R.id.knowMoreRC);
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
                String C= Cap.getText().toString();

                Bundle bundle = new Bundle();

                bundle.putString("Voltage",V);
                bundle.putString("Resistance",res);
                bundle.putString("Capacitance",C);
                if( V.isEmpty() || res.isEmpty() || C.isEmpty()){

                    if( V.isEmpty())
                    {
                        Volt.setError( "Required field " );
                    }
                    if( res.isEmpty())
                    {
                        Res.setError( "Required field " );
                    }
                    if( C.isEmpty())
                    {
                        Cap.setError( "Required field " );
                    }
                }
                else
                {
                    Intent i = new Intent(getApplicationContext(), resultRC.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }

            }
        });
    }
}