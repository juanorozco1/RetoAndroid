package com.example.juansebastian.a1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    TextView contador;
    SharedPreferences sharedPreferences;
    EditText input;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences =this.getPreferences(Context.MODE_PRIVATE);
        input = (EditText) findViewById(R.id.input);
        contador = (TextView) findViewById(R.id.contadorView);
        count = sharedPreferences.getInt("CONTADOR",1);
        contador.setText("se ha logueado "+count+" veces");


        boton1= (Button)findViewById(R.id.send);

        boton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Hola Sebas", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, resultado.class);
                i.putExtra("contador",count);
                i.putExtra("valor",input.getText().toString());
                startActivity(i);
            }
        });
    }

    @Override
    protected void onDestroy() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("CONTADOR",count+1);
        editor.commit();
        super.onDestroy();
    }
}
