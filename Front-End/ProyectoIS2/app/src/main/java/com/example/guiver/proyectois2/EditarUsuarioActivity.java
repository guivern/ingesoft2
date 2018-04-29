package com.example.guiver.proyectois2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        Intent intent = getIntent();
        String message1 = intent.getStringExtra("usuario");
        String message2 = intent.getStringExtra("ids");

        //establece un nuevo text al textView
        TextView textView = findViewById(R.id.textView19);
        textView.setText(message1);

        TextView textView2 = findViewById(R.id.textView20);
        textView2.setText(message2);



    }

    public void aceptar(View view) throws JSONException {

        //Intent intent = new Intent(this, MenuActivity.class);
        //recupera los valores ingresados por el usuario
        EditText editTextId = (EditText) findViewById(R.id.editText5);
        EditText editTextUsuario = (EditText) findViewById(R.id.editText6);
        EditText editTextPassword= (EditText) findViewById(R.id.editText8);

        String url = MainActivity.URL_BASE + "/entidades.usuarios/" + editTextId.getText().toString();
        try {
            String resp = executeGet(url);
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

        String url = MainActivity.URL_BASE + "/entidades.usuarios/" + editTextId.getText().toString();

        //crea el objeto json que se enviara con la peticion
        JSONObject loginParams = new JSONObject();

        try {
            loginParams.put("password", editTextPassword.getText().toString());
            loginParams.put("usuario", editTextUsuario.getText().toString());
            loginParams.put("nroUsuario", editTextId.getText().toString());

            executePut(url, loginParams.toString());
            Toast.makeText(this,"Se realizo la modificación con éxito.", 10).show();
        } catch (JSONException e) {
            Toast.makeText(this,"Ocurrio un error. No Se realizó la modificación.", 10).show();
        }

    }

    public String executeGet(String targetURL) {
        int timeout=5000;
        URL url;
        HttpURLConnection connection = null;
        try {
            //establece la conexion

            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

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
            Toast.makeText(this,e.toString(), 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    public String executePut(String targetURL,String urlParameters) {
        int timeout=5000;
        URL url;
        HttpURLConnection connection = null;
        try {
            //establece la conexion

            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
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
            Toast.makeText(this,"Error de conexión.", 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

}
