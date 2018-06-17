package com.example.guiver.proyectois2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;

public class ListaUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("usuario");
        int message3 = intent.getIntExtra("cont",0);
        String message2;
        String usuarioActual = null;
        try {
            usuarioActual = MainActivity.Usuario.getString("usuario");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(usuarioActual.equals(MainActivity.usuarioAdmin)){
            message2 = intent.getStringExtra("pass");
        }
        else{//no es Admin
            TextView textView1 = findViewById(R.id.textView15);
            textView1.setText("Id");
            message2 = intent.getStringExtra("id");
        }


        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView8);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView12);
        textView2.setText(message2);

        TextView textView3 = findViewById(R.id.textView70);
        textView3.setText("Cantidad usuarios: " + message3);

    }
    public void cancelar(View view){
        finish();
    }
}
