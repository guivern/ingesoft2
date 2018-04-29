package com.example.guiver.proyectois2;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegistroUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        Intent intent = getIntent();
    }

    /*Metodo que sera llamado cuando el usuario haga click en el boton login*/
    public void registrar(View view){

        //recupera los valores ingresados por el usuario
        EditText editTextUserName = (EditText) findViewById(R.id.editText3);
        EditText editTextPassword = (EditText) findViewById(R.id.editText4);
        int resp;
        //crea el objeto json que se enviara con la peticion
        JSONObject userParams = new JSONObject();

        try {
            userParams.put("password", editTextPassword.getText().toString());
            userParams.put("usuario", editTextUserName.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            String url = MainActivity.URL_BASE + "/entidades.usuarios";
            resp = executePost(url, userParams.toString());
            if (resp != 204){
                Toast.makeText(this,"Error, no se pudo completar el registro", 5).show();
                return;
            }
            Toast.makeText(this,"Registro exitoso", 5).show();
        }
        catch(NullPointerException e){
            Toast.makeText(this,"No se pudo conectar con el servidor", 5).show();
        }


    }

    /*Metodo que realiza la conexion con el servidor y solicita el servicio post del login*/
    public int executePost(String targetURL,String urlParameters) {
        int timeout=5000;
        URL url;
        HttpURLConnection connection = null;
        try {
            //establece la conexion

            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);

            //envia la peticion
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            return connection.getResponseCode();

        } catch (Exception e) {
            Toast.makeText(this,"Error de conexión", 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return 1;
    }

}
