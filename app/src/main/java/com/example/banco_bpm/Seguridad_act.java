package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {

    private EditText edit;
    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        edit = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
    }

    private SecretKeySpec generatekey(String password) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sha.digest(key);
        SecretKeySpec secretkey = new SecretKeySpec(key, "AES");
        return secretkey;
    }

    public String Encriptar(String datos, String password) throws Exception {

        if (!edit.getText().toString().isEmpty()) {
            SecretKeySpec secretkey = generatekey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretkey);

            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);
            return datosEncriptadosString;

        } else {
            Toast.makeText(this, "Debe Ingresar una clave", Toast.LENGTH_LONG).show();
            return null;
        }
    }

        public void Encriptar (View v)
        {
            try {
                String mensaje = Encriptar(edit.getText().toString(), tv.getText().toString());
                tv.setText(mensaje);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }