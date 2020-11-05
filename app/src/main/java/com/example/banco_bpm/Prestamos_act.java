package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Creditos;
import Clases.Cuotas;
import Clases.Salario;

public class Prestamos_act extends AppCompatActivity {

    private Spinner Spinner1 , Spinner2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        Spinner1 =(Spinner)findViewById(R.id.spinnerClientes);
        Spinner2 =(Spinner)findViewById(R.id.spinnerCreditos);
        tv = (TextView)findViewById(R.id.tv);

        ArrayList<String> ListadoClientes = (ArrayList<String>) getIntent().getSerializableExtra("ListadoClientes");
        ArrayList<String> ListadoCreditos = (ArrayList<String>) getIntent().getSerializableExtra("ListadoCreditos");

        ArrayAdapter<String> adapt = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ListadoClientes);
        ArrayAdapter<String> adaptr = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ListadoCreditos);

        Spinner1.setAdapter(adapt);
        Spinner2.setAdapter(adaptr);
    }

    public void Calcular_Prestamos(View v)
    {
        Creditos cre = new Creditos();
        Salario sa = new Salario();
        String Clientes = Spinner1.getSelectedItem().toString();
        String Creditos = Spinner2.getSelectedItem().toString();
        int Credito_Hipotecario = Integer.parseInt(cre.getCredito_Hipotecario());
        int Credito_Automotriz = Integer.parseInt(cre.getCredito_Automotriz());
        int Salario_uno = Integer.parseInt(sa.getSalario_uno());
        int Salario_dos = Integer.parseInt(sa.getSalario_dos());
        int resultado = Credito_Hipotecario + Salario_uno ;
        int resultadoDos = Credito_Automotriz + Salario_uno;
        int resultadoTres = Credito_Hipotecario + Salario_dos;
        int resultadoCuatro = Credito_Automotriz + Salario_dos;

        if (Clientes.equals("Axel") && Creditos.equals("Credito_Hipotecario"))
        {
            tv.setText("El valor del Prestamo Hipotecario es : " + resultado);
        }

        if (Clientes.equals("Axel") && Creditos.equals("Credito_Automotriz"))
        {
            tv.setText("El valor del Prestamo Automotriz es: " + resultadoDos);
        }

        if (Clientes.equals("Roxana") && Creditos.equals("Credito_Hipotecario"))
        {
            tv.setText("El valor del Prestamo Hipotecario es : " + resultadoTres);
        }
        if (Clientes.equals("Roxana") && Creditos.equals("Credito_Automotriz"))
        {
            tv.setText("El valor del Prestamo Automotriz es : " + resultadoCuatro);
        }


    }

    public void Calcular_Deudas(View v)
    {
        Creditos cre = new Creditos();
        Salario sa = new Salario();
        Cuotas cuo = new Cuotas();
        String Clientes = Spinner1.getSelectedItem().toString();
        String Creditos = Spinner2.getSelectedItem().toString();
        int Credito_Hipotecario = Integer.parseInt(cre.getCredito_Hipotecario());
        int Credito_Automotriz = Integer.parseInt(cre.getCredito_Automotriz());
        int Cuota_Hipotecario = Integer.parseInt(cuo.getCuota_Hipotecario());
        int Cuota_Automotriz = Integer.parseInt(cuo.getCuota_Automotriz());
        int Salario_uno = Integer.parseInt(sa.getSalario_uno());
        int Salario_dos = Integer.parseInt(sa.getSalario_dos());
        int resultado_Cuota = Credito_Hipotecario + Salario_uno/Cuota_Hipotecario;
        int resultado_CuotaDos = Credito_Automotriz + Salario_uno/Cuota_Automotriz;
        int resultado_CuotaTres = Credito_Hipotecario + Salario_dos/Cuota_Hipotecario;
        int resultado_CuotaCuatro = Credito_Automotriz + Salario_dos/Credito_Automotriz;

        if (Clientes.equals("Axel") && Creditos.equals("Credito_Hipotecario"))
        {
            tv.setText("El valor del Prestamo Hipotecario es : " + resultado_Cuota);
        }

        if (Clientes.equals("Axel") && Creditos.equals("Credito_Automotriz"))
        {
            tv.setText("El valor del Prestamo Automotriz es: " + resultado_CuotaDos);
        }

        if (Clientes.equals("Roxana") && Creditos.equals("Credito_Hipotecario"))
        {
            tv.setText("El valor del Prestamo Hipotecario es : " + resultado_CuotaTres);
        }
        if (Clientes.equals("Roxana") && Creditos.equals("Credito_Automotriz"))
        {
            tv.setText("El valor del Prestamo Automotriz es : " + resultado_CuotaCuatro);
        }

    }
}