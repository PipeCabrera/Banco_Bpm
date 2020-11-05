package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {

    private EditText edcodigo,ednombre,edsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        edcodigo =(EditText)findViewById(R.id.codigo);
        ednombre =(EditText)findViewById(R.id.nombre);
        edsalario =(EditText)findViewById(R.id.salario);
    }
    public void añadirCliente(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero1", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if (!edcodigo.getText().toString().isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("codigo", edcodigo.getText().toString());
            registro.put("nombre", ednombre.getText().toString());
            registro.put("salario", edsalario.getText().toString());

            bd.insert("Clientes", null, registro);
            bd.close();
            Toast.makeText(this, "Se ha guardado un Cliente", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Debe ingresar un Cliente", Toast.LENGTH_LONG).show();
        }
    }

    public void MostrarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero1",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if (!codigo.isEmpty()) {
            Cursor fila = bd.rawQuery("SELECT nombre , salario FROM Clientes WHERE codigo =" + codigo, null);

            if (fila.moveToFirst()) {
                ednombre.setText(fila.getString(0));
                edsalario.setText(fila.getString(1));
            }
            else {
                Toast.makeText(this, "Debe ingresar el codigo del Cliente", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void EliminarCliente (View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero1",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        bd.delete("Clientes","codigo= " + codigo, null);
        bd.close();

        Toast.makeText(this, "Se ha eliminado el Cliente", Toast.LENGTH_LONG).show();
    }

    public void ActualizarCliente (View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero1",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();
        ContentValues content = new ContentValues();

        content.put("codigo", edcodigo.getText().toString());
        content.put("nombre",ednombre.getText().toString());
        content.put("salario",edsalario.getText().toString());

        if (!codigo.isEmpty()) {
            bd.update("Clientes", content ,"codigo="+ codigo,null);
            Toast.makeText(this,"Se ha actualizado el Cliente", Toast.LENGTH_LONG).show();
        }
    }
}