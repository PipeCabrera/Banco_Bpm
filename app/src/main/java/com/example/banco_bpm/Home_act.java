package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a,R.drawable.b,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf =(ViewFlipper) findViewById(R.id.slider);
        for (int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }
    public void  flip_image(int i)
    {
        ImageView View = new ImageView(this);
        View.setBackgroundResource(i);
        vf.addView(View);
        vf.setFlipInterval(2300);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void Clientes (View v)
    {
        ArrayList<String> Clientes = new ArrayList<String>();
        ArrayList<String> Creditos = new ArrayList<String>();

        Clientes.add("Axel");
        Clientes.add("Roxana");

        Creditos.add("Credito_Hipotecario");
        Creditos.add("Credito_Automotriz");

        Intent i = new Intent(this,Prestamos_act.class);
        i.putExtra("ListadoClientes",Clientes);
        i.putExtra("ListadoCreditos",Creditos);
        startActivity(i);
    }

    public void Info (View v)
    {
        Intent i = new Intent(this,Info_act.class);
        startActivity(i);
    }

    public void Seguridad (View v)
    {
        Intent i = new Intent(this,Seguridad_act.class);
        startActivity(i);
    }

    public void Calcular ( View v)
    {
        Intent i = new Intent(this,Prestamos_act.class);
        startActivity(i);
    }

    public void Gestionar_Clientes (View v)
    {
        Intent i = new Intent(this,Clientes_act.class);
        startActivity(i);
    }
}