package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText contraseña;
    private ProgressBar pb;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.name);
        contraseña = (EditText) findViewById(R.id.pass);
        pb = (ProgressBar) findViewById(R.id.pb);
        btn = (Button) findViewById(R.id.btn);

        pb.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });


    }

    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            String V_user = nombre.getText().toString();
            String v_pass = contraseña.getText().toString();

            if (V_user.equals("android")&& v_pass.equals("123"))
            {
                Intent i = new Intent(getBaseContext(),Home_act.class);
                startActivity(i);
            }
        }

        protected String doInBackground(String... strings) {
                for (int i = 1; i<=10; i++)
                {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            return null;
        }
    }

}