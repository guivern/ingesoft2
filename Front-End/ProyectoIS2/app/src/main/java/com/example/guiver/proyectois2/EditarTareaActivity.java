package com.example.guiver.proyectois2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class EditarTareaActivity extends AppCompatActivity {
    Connection connection=new Connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_tarea);

        Intent intent = getIntent();
        String message1 = intent.getStringExtra("tareas");
        String message2 = intent.getStringExtra("ids");

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView52);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView51);
        textView2.setText(message2);

    }

    public void aceptar(View view) throws JSONException {

        //Intent intent = new Intent(this, MenuActivity.class);
        //recupera los valores ingresados por el usuario
        //cierra el teclado
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        EditText editTextId = (EditText) findViewById(R.id.editText9);
        EditText editTextTitulo= (EditText) findViewById(R.id.editText11);
        EditText editTextDescripcion= (EditText) findViewById(R.id.editText14);
        EditText editTextFecha= (EditText) findViewById(R.id.editText17);

        if(editTextId.getText().toString().equals("")){
            Toast.makeText(this,"Debe ingresar un id", 10).show();
            return;
        }

        String url = MainActivity.URL_BASE + "/entidades.tareas/" + editTextId.getText().toString();
        try {
            String resp = connection.executeGet(url, this);
            JSONObject tarea = new JSONObject(resp.toString());

            //verifica si la tarea solicita corresponde al usuario que lo solicita
            if(tarea.getJSONObject("nroUsuarioFk").getInt("nroUsuario") == MainActivity.IdUsuario){
                editTextTitulo.setText(tarea.getString("titulo"));
                editTextDescripcion.setText(tarea.getString("descripcion"));
                editTextFecha.setText(tarea.getString("fechaFin").substring(0,10));
            }
            else {//el id no corresponde a una tarea del usuario
                throw new Exception();
            }

        }
        catch (Exception e){
            Toast.makeText(this,"El id ingresado no es válido.", 10).show();
        }

    }

    public void editar(View view){
        EditText editTextId = (EditText) findViewById(R.id.editText9);
        EditText editTextTitulo= (EditText) findViewById(R.id.editText11);
        EditText editTextDescripcion= (EditText) findViewById(R.id.editText14);
        EditText editTextFecha= (EditText) findViewById(R.id.editText17);

        if(editTextId.getText().toString().equals("")){
            Toast.makeText(this,"Debe ingresar un id", 10).show();
            return;
        }

        String url = MainActivity.URL_BASE + "/entidades.tareas/" + editTextId.getText().toString();

        //crea el objeto json que se enviara con la peticion
        JSONObject loginParams = new JSONObject();
        JSONObject nroEstado = new JSONObject();
        try {
            nroEstado.put("estado","No iniciada");
            nroEstado.put("nroEstado", 1);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {

            loginParams.put("descripcion", editTextDescripcion.getText().toString());
            loginParams.put("fechaFin", (editTextFecha.getText().toString() + "T00:00:00-04:00"));
            loginParams.put("nroTarea",editTextId.getText().toString());
            loginParams.put("nroUsuarioFk", MainActivity.Usuario);
            loginParams.put("tareaNroEstado", nroEstado);
            loginParams.put("titulo", editTextTitulo.getText().toString());

            connection.executePut(url, loginParams.toString(),this);
            Toast.makeText(this,"Se realizo la modificación con éxito.", 10).show();
            finish();
        } catch (JSONException e) {
            Toast.makeText(this,"Ocurrio un error. No Se realizó la modificación.", 10).show();
        }

    }
    public void cancelar(View view){
        finish();
    }

}
