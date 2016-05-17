package com.example.juansebastian.a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    TextView resultado;
    String valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        resultado = (TextView) findViewById(R.id.resultado);

        int count;

        Bundle extras = getIntent().getExtras();
        count = extras.getInt("contador");
        valor = extras.getString("valor");

        boolean texto = true;
        boolean numero = true;
        boolean combinado = false;

        for (int i = 0; i<valor.length(); i++ ){
            if(Character.isDigit(valor.charAt(i)))
                texto = false;
            if(!Character.isDigit(valor.charAt(i)))
                numero = false;

        }
        if(texto == false && numero == false)
            combinado = true;
        String resulta="";
        if(texto){
            resulta = valor + count;

        }else if(numero){
            resulta = "suma: "+(Integer.parseInt(valor)+count) + " " +
                    "resta: " + (Integer.parseInt(valor)-count) + " " +
                    "multiplicacion: " + (Integer.parseInt(valor)*count) + " " +
                    "division: " + ((float)Integer.parseInt(valor)/(float)count);

        }else if(combinado){
            String digitos = "";
            String letras = "";
            for (int i = 0; i<valor.length(); i++ ){
                if(Character.isDigit(valor.charAt(i))){
                    digitos = digitos + valor.charAt(i);
                }

                if(!Character.isDigit(valor.charAt(i))){
                    letras = letras + valor.charAt(i);
                }
                resulta= "Digitos: "+ digitos +
                        "Letras: "+ letras;
            }
        }

        resultado.setText(resulta);
    }
}
