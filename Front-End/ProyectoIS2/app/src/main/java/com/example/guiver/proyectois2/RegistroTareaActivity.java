package com.example.guiver.proyectois2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistroTareaActivity extends AppCompatActivity {
    Connection connection=new Connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tarea);
    }

    public void registrar(View view){

        //recupera los valores ingresados por el usuario
        EditText editTextTitulo = (EditText) findViewById(R.id.editText10);
        EditText editTextDescripcion = (EditText) findViewById(R.id.editText12);
        EditText editTextFecha = (EditText) findViewById(R.id.editText18);
        String resp;
        //crea el objeto json que se enviara con la peticion
        JSONObject userParams = new JSONObject();
        JSONObject nroEstado = new JSONObject();
        try {
            nroEstado.put("estado","No iniciada");
            nroEstado.put("nroEstado", 1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try {
            userParams.put("descripcion", editTextDescripcion.getText().toString());
            userParams.put("fechaFin", (editTextFecha.getText().toString() + "T00:00:00-04:00"));
            userParams.put("nroUsuarioFk", MainActivity.Usuario);
            userParams.put("tareaNroEstado", nroEstado);
            userParams.put("titulo", editTextTitulo.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            String url = MainActivity.URL_BASE + "/entidades.tareas";
            //Toast.makeText(this,userParams.toString(), 30).show();
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
