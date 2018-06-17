package com.example.guiver.proyectois2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;


public class MenuActivity extends AppCompatActivity {
    Connection connection = new Connection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView5);
        textView.setText("usuario: " + MainActivity.usuarioActual);

    }

    public void menuUsuarios(View view){
        //Toast.makeText(this,"En construcción", 5).show();
        Intent intent = new Intent(this, MenuUsuariosActivity.class);
        startActivity(intent);
    }

    public void salir(View view){
        //Toast.makeText(this,"En construcción", 5).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void menuTareas(View view){
        //Toast.makeText(this,"En construcción", 5).show();
        Intent intent = new Intent(this, MenuTareasActivity.class);
        startActivity(intent);
    }

    public void notificaciones(){

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Aviso");
        alertDialog.setMessage("Tiene tareas pendientes.\nHeche un vistazo a su lista de tareas.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}
