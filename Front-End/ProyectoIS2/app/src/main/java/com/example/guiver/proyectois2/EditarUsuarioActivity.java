package com.example.guiver.proyectois2;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EditarUsuarioActivity extends AppCompatActivity {
    Connection connection = new Connection();
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
        setContentView(R.layout.activity_editar_usuario);

        Intent intent = getIntent();
        TextView textView = findViewById(R.id.textView19);
        TextView textView2 = findViewById(R.id.textView20);
        TextView textView21 = findViewById(R.id.textView21);
        TextView textView17 = findViewById(R.id.textView17);
        TextView textView18 = findViewById(R.id.textView18);
        EditText editText = findViewById(R.id.editText5);
        Button button = findViewById(R.id.button13);


        if(usuarioActual.equals(MainActivity.usuarioAdmin)){
            String message1 = intent.getStringExtra("usuario");
            String message2 = intent.getStringExtra("ids");

            //establece un nuevo text al textView
            textView.setText(message1);
            textView2.setText(message2);

        }
        else {

            ConstraintLayout cl= (ConstraintLayout) findViewById(R.id.constraintLayout1);
            cl.removeView(textView);
            cl.removeView(textView2);
            cl.removeView(textView17);
            cl.removeView(textView18);
            cl.removeView(textView21);
            button.setVisibility(View.INVISIBLE);
            cl.removeView(editText);

            int id = intent.getIntExtra("id",0);

            EditText editTextUsuario = (EditText) findViewById(R.id.editText6);
            EditText editTextPassword= (EditText) findViewById(R.id.editText8);

            String url = MainActivity.URL_BASE + "/entidades.usuarios/" + id;
            try {
                String resp = connection.executeGet(url, this);
                JSONObject usr = new JSONObject(resp.toString());


                editTextUsuario.setText(usr.getString("usuario"));
                editTextPassword.setText(usr.getString("password"));

            }
            catch (Exception e){
                Toast.makeText(this,"Ha ocurrido un error.", 10).show();
            }


        }



    }

    public void aceptar(View view) throws JSONException {

        //Intent intent = new Intent(this, MenuActivity.class);
        //recupera los valores ingresados por el usuario

        //cierra el teclado
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        EditText editTextId = (EditText) findViewById(R.id.editText5);
        EditText editTextUsuario = (EditText) findViewById(R.id.editText6);
        EditText editTextPassword= (EditText) findViewById(R.id.editText8);

        if(editTextId.getText().toString().equals("")){
            Toast.makeText(this,"Debe ingresar el id", 5).show();
            return;
        }

        String url = MainActivity.URL_BASE + "/entidades.usuarios/" + editTextId.getText().toString();
        try {
            String resp = connection.executeGet(url, this);
            JSONObject usr = new JSONObject(resp.toString());


            editTextUsuario.setText(usr.getString("usuario"));
            editTextPassword.setText(usr.getString("password"));

        }
        catch (Exception e){
            Toast.makeText(this,"El id ingresado no es válido.", 10).show();
        }

    }

    public void editar(View view){
        EditText editTextId = (EditText) findViewById(R.id.editText5);
        EditText editTextUsuario = (EditText) findViewById(R.id.editText6);
        EditText editTextPassword= (EditText) findViewById(R.id.editText8);
        if(editTextId.getText().toString().equals("")){
            Toast.makeText(this,"Debe ingresar el id", 5).show();
            return;
        }

        String id = usuarioActual.equals(MainActivity.usuarioAdmin)? editTextId.getText().toString() : String.valueOf(MainActivity.IdUsuario);

        String url = MainActivity.URL_BASE + "/entidades.usuarios/" + id;

        //crea el objeto json que se enviara con la peticion
        JSONObject loginParams = new JSONObject();

        try {
            loginParams.put("password", editTextPassword.getText().toString());
            loginParams.put("usuario", editTextUsuario.getText().toString());
            loginParams.put("nroUsuario", id);

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
