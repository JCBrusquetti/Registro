package com.saludo.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    private TextView lblNombre, lblFecha, lblTelefono, lblEmail, lblDescripcion;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        lblNombre = (TextView) findViewById(R.id.txtNombre);
        lblFecha = (TextView) findViewById(R.id.txtFecha);
        lblTelefono = (TextView) findViewById(R.id.txtTelefono);
        lblEmail = (TextView) findViewById(R.id.txtEmail);
        lblDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        editar = (Button) findViewById(R.id.btnEditar);

        String nombre = getIntent().getStringExtra("nombre");
        String fecha = getIntent().getStringExtra("fecha");
        String telefono = getIntent().getStringExtra("telefono");
        String email = getIntent().getStringExtra("email");
        String descripcion = getIntent().getStringExtra("descripcion");

        lblNombre.setText(nombre);
        lblFecha.setText(fecha);
        lblTelefono.setText(telefono);
        lblEmail.setText(email);
        lblDescripcion.setText(descripcion);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });




    }
}