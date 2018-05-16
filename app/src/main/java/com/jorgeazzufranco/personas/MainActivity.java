package com.jorgeazzufranco.personas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jorgeazzufranco.personas.Entidades.DBHelper;

public class MainActivity extends AppCompatActivity {
    private Button btnRegistar,btnConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarControles();
        DBHelper.getInstance(this);

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegistrarActivity.class);
                startActivity(intent);
            }
        });
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ModificarActivity.class);
                startActivity(intent);
            }
        });

    }
    public void inicializarControles(){
        btnRegistar =  findViewById(R.id.Registro);
        btnConsultar=  findViewById(R.id.consultar);
    }
}
