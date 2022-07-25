package com.example.elementocurvas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla2 extends AppCompatActivity {

    public Button Calcular;
    private EditText GRADOS;
    private EditText MINUTOS;
    private EditText SEGUNDOS;
    private EditText RADIO;
    private TextView GCUR;
    private TextView TAN;
    private TextView CLAR;
    private TextView LONGC;
    private TextView EXTERNA;
    private TextView FLECHA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        GRADOS = findViewById(R.id.GRADOS);
        SEGUNDOS = findViewById(R.id.SEGUNDOS);
        MINUTOS = findViewById(R.id.MINUTOS);
        RADIO = findViewById(R.id.RADIO);
        GCUR = (TextView) findViewById(R.id.GCUR);
        TAN = findViewById(R.id.TAN);
        CLAR = findViewById(R.id.CLAR);
        LONGC = findViewById(R.id.LONGC);
        EXTERNA = findViewById(R.id.EXTERNA);
        FLECHA = findViewById(R.id.FLECHA);
        Calcular = (Button) findViewById(R.id.btnCalcular);
    }

    public void btnCalcular(View view) {

        String valor1 = GRADOS.getText().toString();
        String valor2 = MINUTOS.getText().toString();
        String valor3 = SEGUNDOS.getText().toString();
        String valor4 = RADIO.getText().toString();
        String valor5 = GCUR.getText().toString();
        String valor6 = TAN.getText().toString();
        String valor7 = CLAR.getText().toString();
        String valor8 = LONGC.getText().toString();
        String valor9 = EXTERNA.getText().toString();
        String valor10 = FLECHA.getText().toString();


        double valor1d, valor2d, valor3d, valorRd, valorde, valorgc, valortan, valorclar, valorlon, valorext, valorfle;
        valor1d = transformarVariableDeEntrada(valor1);
        valor2d = transformarVariableDeEntrada(valor2);
        valor3d = transformarVariableDeEntrada(valor3);
        valorde = valor1d + (valor2d / 60) + (valor3d / 3600);
        Double result = (valorde);
        valorRd = transformarVariableDeEntrada(valor4);

        valorgc = (572.96 / valorRd);
        // valorgc = transformarVariableDeEntrada(valor5);
        String valorgcs = aplicarFormatoNumerico(valorgc);
        GCUR.setText(valorgcs);

        valortan = valorRd * (Math.tan(valorde / 2));
        // valortan = transformarVariableDeEntrada(valor6);
        String valortang = aplicarFormatoNumerico(valortan);
        TAN.setText(valortang);

        valorclar = 2 * valorRd * (Math.sin(valorde / 2));
        // valorclar = transformarVariableDeEntrada(valor7);
        String valorclarg = aplicarFormatoNumerico(valorclar);
        CLAR.setText(valorclarg);

        valorlon = (valorde / valorgc) * 10;
        // valorlon = transformarVariableDeEntrada(valor8);
        String valorlong = aplicarFormatoNumerico(valorlon);
        LONGC.setText(valorlong);

        valorext = (valorRd) * (1 / Math.cos(valorde / 2) - 1);
        // valorext = transformarVariableDeEntrada(valor9);
        String valorexte = aplicarFormatoNumerico(valorext);
        EXTERNA.setText(valorexte);

        valorfle = valorRd * (1 - Math.cos(valorde / 2));
        // valorfle = transformarVariableDeEntrada(valor10);
        String valorflec = aplicarFormatoNumerico(valorfle);
        FLECHA.setText(valorflec);
    }

    private Double transformarVariableDeEntrada(String variableATransformar) {

        Double valorDeRetorno = Double.valueOf("0");
        try {
            valorDeRetorno = Double.valueOf(variableATransformar);
        } catch (NumberFormatException e) {
            // Captura excepcion para retorno de valor por defecto
        }
        return valorDeRetorno;
    }

    private String aplicarFormatoNumerico(double valorAMostrar) {
        return String.format("%.3f", valorAMostrar);
    }
}
