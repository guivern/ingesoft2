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

public class MainActivity extends AppCompatActivity {
    //se utilizara como clave para el valor a enviar a traves del intent
    public static final String EXTRA_MESSAGE = "com.example.guiver.proyectois2.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Metodo que sera llamado cuando el usuario haga click en el boton login*/
    public void validarLogin(View view){
        Intent intent = new Intent(this, DisplayMenuActivity.class);
        //recupera los valores ingresados por el usuario
        EditText editTextUserName = (EditText) findViewById(R.id.editText);
        EditText editTextPassword = (EditText) findViewById(R.id.editText2);
        String message;
        //crea el objeto json que se enviara con la peticion
        JSONObject loginParams = new JSONObject();

        try {
            loginParams.put("password", editTextPassword.getText().toString());
            loginParams.put("usuario", editTextUserName.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            message = executePost("http://192.168.1.6:8080/ProyectoIS2/webresources/entidades.usuarios/login", loginParams.toString());
            if (message.equals("")){
                Toast.makeText(this,"Login fallido", 5).show();
                return;
            }
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        catch(NullPointerException e){
            Toast.makeText(this,"No se pudo conectar con el servidor", 5).show();
        }


    }

    /*Metodo que realiza la conexion con el servidor y solicita el servicio post del login*/
    public String executePost(String targetURL,String urlParameters) {
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

            // obtiene la respuesta
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {
            Toast.makeText(this,"Error de conexión", 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }
}