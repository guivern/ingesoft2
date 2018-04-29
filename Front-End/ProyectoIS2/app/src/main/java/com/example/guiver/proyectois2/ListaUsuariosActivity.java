package com.example.guiver.proyectois2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListaUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("usuario");
        String message2 = intent.getStringExtra("pass");

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView8);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView12);
        textView2.setText(message2);
    }
}
