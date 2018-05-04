package com.example.guiver.proyectois2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EliminarTareaActivity extends AppCompatActivity {
    Connection connection = new Connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_tarea);

        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("tarea");
        String message2 = intent.getStringExtra("id");

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView60);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView59);
        textView2.setText(message2);

    }

    public void eliminar(View view){

        //Intent intent = new Intent(this, MenuActivity.class);
        //recupera los valores ingresados por el usuario
        EditText editTextId = (EditText) findViewById(R.id.editText15);

        String resp;

        try {
            String url = MainActivity.URL_BASE+ "/entidades.tareas/" + editTextId.getText().toString();
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
