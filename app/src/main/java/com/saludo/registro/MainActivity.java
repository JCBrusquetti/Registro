package com.saludo.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private EditText nombre,fecha,telefono,email,descripcion;
    private Button myBoton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayDate = (TextView) findViewById(R.id.etFecha);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int año = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDataSetListener,año,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
                mes=mes+1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: "+ mes + "/" + dia + "/" + año);

                String date = mes+"/"+dia+"/"+año;
                mDisplayDate.setText(date);
            }
        };
        nombre = (EditText) findViewById(R.id.etNombre);
        fecha = (EditText) findViewById(R.id.etFecha);
        telefono = (EditText) findViewById(R.id.etTelefono);
        email = (EditText) findViewById(R.id.etEmail);
        descripcion = (EditText) findViewById(R.id.etDescripcion);
        myBoton = (Button) findViewById(R.id.btnSiguiente);

        myBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Detalles.class);
                i.putExtra("nombre",nombre.getText()+"");
                i.putExtra("fecha","Fecha de nacimiento: "+fecha.getText()+"");
                i.putExtra("telefono","Teléfono: "+ telefono.getText()+"");
                i.putExtra("email","Email: "+email.getText()+"");
                i.putExtra("descripcion",getString(R.string.descrip)+": "+descripcion.getText()+"");
                startActivity(i);
            }
        });



    }



}