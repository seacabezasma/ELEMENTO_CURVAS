package com.example.elementocurvas;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //METODO BOTON SIGUIENTE
    public void INICIAR(View view){
        Intent INICIAR = new Intent(this, Pantalla2.class);
        startActivity(INICIAR);
    }
}