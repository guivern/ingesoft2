package com.example.guiver.proyectois2;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EliminarUsuarioActivity extends AppCompatActivity {
    Connection connection = new Connection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_usuario);

        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("usuario");
        String message2 = intent.getStringExtra("ids");

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView31);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView30);
        textView2.setText(message2);

    }
    public void eliminar(View view){

        //Intent intent = new Intent(this, MenuActivity.class);
        //recupera los valores ingresados por el usuario
        EditText editTextId = (EditText) findViewById(R.id.editText7);

        String resp;

        try {
            String url = MainActivity.URL_BASE+ "/entidades.usuarios/" + editTextId.getText().toString();
            //Toast.makeText(this,url, 5).show();
            resp = connection.executeDelete(url, this);
            //Toast.makeText(this, resp, 5).show();

            if (resp.equals("")){
                Toast.makeText(this,"Eliminación exitosa.", 5).show();
                return;
            }
            //intent.putExtra(EXTRA_MESSAGE, editTextUserName.getText().toString());
            //startActivity(intent);
        }
        catch(NullPointerException e){
            Toast.makeText(this,"El id ingresado no es válido.", 5).show();
        }


    }

}
