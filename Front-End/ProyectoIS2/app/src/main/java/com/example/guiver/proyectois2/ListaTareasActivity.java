package com.example.guiver.proyectois2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListaTareasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas);


        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("id");
        String message2 = intent.getStringExtra("tarea");
        String message3 = intent.getStringExtra("fec");
        String message4 = intent.getStringExtra("estado");

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView46);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView47);
        textView2.setText(message2);

        TextView textView3 = findViewById(R.id.textView49);
        textView3.setText(message3);

        TextView textView4 = findViewById(R.id.textView48);
        textView4.setText(message4);

    }
}
