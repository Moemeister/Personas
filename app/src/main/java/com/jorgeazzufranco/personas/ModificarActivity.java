package com.jorgeazzufranco.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jorgeazzufranco.personas.Datos.Persona;
import com.jorgeazzufranco.personas.Entidades.DBHelper;

public class ModificarActivity extends AppCompatActivity {
    private EditText id,nombre;
    private Button btnBuscar,btnActualziar,btnEliminar,btnLimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        id = findViewById(R.id.dui);
        nombre = findViewById(R.id.txtNombre);
        btnBuscar = findViewById(R.id.buscar);
        btnActualziar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = DBHelper.myDB.findUser(id.getText().toString());
                if(p==null){
                    Toast.makeText(getApplicationContext(),"Usuario no encontrado :(",Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    nombre.setText(p.getNombre());
                }
            }
        });
        btnActualziar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(),nombre.getText().toString()));
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                limpiar();
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

    }
    public void limpiar(){
        nombre.setText("");
        id.setText("");
    }
}
