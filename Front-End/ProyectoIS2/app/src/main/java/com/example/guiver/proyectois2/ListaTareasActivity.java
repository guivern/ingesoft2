package com.example.guiver.proyectois2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;

public class ListaTareasActivity extends AppCompatActivity {
    String usuarioActual;

    {
        try {
            usuarioActual = MainActivity.Usuario.getString("usuario");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas);


        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("id");
        String message2 = intent.getStringExtra("tarea");

        String message3;
        if(usuarioActual.equals(MainActivity.usuarioAdmin)){
            TextView tv = findViewById(R.id.textView38);
            tv.setText("Usuario");
            message3= intent.getStringExtra("usuario");
        }
        else {
            message3 = intent.getStringExtra("fec");
        }

        String message4 = intent.getStringExtra("estado");
        int message5 = intent.getIntExtra("cont",0);

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView46);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView47);
        textView2.setText(message2);

        TextView textView3 = findViewById(R.id.textView49);
        textView3.setText(message3);

        TextView textView4 = findViewById(R.id.textView48);
        textView4.setText(message4);

        TextView textView5 = findViewById(R.id.textView71);
        textView5.setText("Cantidad tareas: " + message5);

    }
    public void cancelar(View view){
        finish();
    }
}
