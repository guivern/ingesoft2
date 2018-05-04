package com.example.guiver.proyectois2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView5);
        textView.setText("Usuario: " + message);
    }

    public void menuUsuarios(View view){
        //Toast.makeText(this,"En construcción", 5).show();
        Intent intent = new Intent(this, MenuUsuariosActivity.class);
        startActivity(intent);
    }

    public void menuTareas(View view){
        //Toast.makeText(this,"En construcción", 5).show();
        Intent intent = new Intent(this, MenuTareasActivity.class);
        startActivity(intent);
    }


}
