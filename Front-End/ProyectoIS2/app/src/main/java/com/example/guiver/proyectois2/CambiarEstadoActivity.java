package com.example.guiver.proyectois2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class CambiarEstadoActivity extends AppCompatActivity {
    Connection connection = new Connection();
    JSONObject tarea = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_estado);


        //obtiene el intent que activo el activity
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("id");
        String message2 = intent.getStringExtra("tarea");
        String message4 = intent.getStringExtra("estado");

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView66);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView67);
        textView2.setText(message2);

        TextView textView4 = findViewById(R.id.textView68);
        textView4.setText(message4);

    }

    public void aceptar(View view) throws JSONException {

        //Intent intent = new Intent(this, MenuActivity.class);
        //recupera los valores ingresados por el usuario
        //cierra el teclado
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        EditText editTextId = (EditText) findViewById(R.id.editText16);


        String url = MainActivity.URL_BASE + "/entidades.tareas/" + editTextId.getText().toString();
        try {
            String resp = connection.executeGet(url, this);
            tarea= new JSONObject(resp.toString());

            //verifica si la tarea solicita corresponde al usuario que lo solicita
            if(tarea.getJSONObject("nroUsuarioFk").getInt("nroUsuario") != MainActivity.IdUsuario){
                tarea = null;
                throw new Exception(); //el id no corresponde a una tarea del usuario
            }
        }
        catch (Exception e){
            Toast.makeText(this,"El id ingresado no es válido.", 10).show();
        }

    }

    public void editar(View view){
        EditText editTextId = (EditText) findViewById(R.id.editText16);
        String url = MainActivity.URL_BASE + "/entidades.tareas/" + editTextId.getText().toString();
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton5);
        //crea el objeto json que se enviara con la peticion
        JSONObject loginParams = new JSONObject();
        JSONObject nroEstado = new JSONObject();

        try{
            if(radioButton1.isChecked()) {
                nroEstado.put("estado", "No iniciada");
                nroEstado.put("nroEstado", 1);
            }
            else if(radioButton2.isChecked()){
                nroEstado.put("estado", "En progreso");
                nroEstado.put("nroEstado", 2);
            }
            else if(radioButton3.isChecked()){
                nroEstado.put("estado", "Completada");
                nroEstado.put("nroEstado", 3);
            }
            else{
                throw new Exception();
            }
        } catch (Exception e) {
            Toast.makeText(this,"Debe seleccionar un estado.", 10).show();
        }

        try {

            loginParams.put("descripcion", tarea.getString("descripcion"));
            loginParams.put("fechaFin", tarea.getString("fechaFin"));
            loginParams.put("nroTarea",tarea.getInt("nroTarea"));
            loginParams.put("nroUsuarioFk", MainActivity.Usuario);
            loginParams.put("tareaNroEstado", nroEstado);
            loginParams.put("titulo", tarea.getString("titulo"));

            connection.executePut(url, loginParams.toString(),this);
            Toast.makeText(this,"La tarea cambio de estado a: " + nroEstado.getString("estado"), 10).show();
        } catch (JSONException e) {
            Toast.makeText(this,"Ocurrio un error. No Se realizó la modificación.", 10).show();
        }

    }

}
