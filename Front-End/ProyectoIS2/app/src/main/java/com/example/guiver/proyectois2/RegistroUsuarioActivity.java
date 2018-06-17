package com.example.guiver.proyectois2;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegistroUsuarioActivity extends AppCompatActivity {
    Connection connection = new Connection();
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        Intent intent = getIntent();
        data = intent.getStringExtra("padre");
    }

    public void registrar(View view){

        //recupera los valores ingresados por el usuario
        EditText editTextUserName = (EditText) findViewById(R.id.editText3);
        EditText editTextPassword = (EditText) findViewById(R.id.editText4);
        String resp;

        if(editTextPassword.getText().toString().equals("") || editTextUserName.getText().toString().equals("")){
            Toast.makeText(this,"Debe completar los campos", 5).show();
            return;
        }

        //crea el objeto json que se enviara con la peticion
        JSONObject userParams = new JSONObject();

        try {
            userParams.put("password", editTextPassword.getText().toString());
            userParams.put("usuario", editTextUserName.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            String url = MainActivity.URL_BASE + "/entidades.usuarios";
            resp = connection.executePost(url, userParams.toString(), this);
            if (resp== null){
                Toast.makeText(this,"Error, no se pudo completar el registro", 5).show();
                return;
            }
            Toast.makeText(this,"Registro exitoso", 5).show();
             finish();
        }
        catch(NullPointerException e){
            Toast.makeText(this,"No se pudo conectar con el servidor", 5).show();
        }

    }

    public void cancelar(View view){
        finish();
    }

}
