package com.jorgeazzufranco.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jorgeazzufranco.personas.Datos.Persona;
import com.jorgeazzufranco.personas.Entidades.DBHelper;

public class RegistrarActivity extends AppCompatActivity {
    private EditText txtId,txtNombre;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        btnEnviar =findViewById(R.id.registrar);
        txtId = findViewById(R.id.duii);
        txtNombre = findViewById(R.id.nombree);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(
                        txtId.getText().toString(),
                        txtNombre.getText().toString()
                ));
                if(flag)
                    Log.d("Edit",txtNombre.getText().toString());
            }
        });

    }
}
