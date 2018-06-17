package com.example.guiver.proyectois2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    public static final String URL_BASE = "http://10.42.0.1:8080/ProyectoIS2/webresources";
    public static int IdUsuario;
    public static JSONObject Usuario;
    public static String usuarioAdmin = "Admin";
    public static String passAdmin = "1233";
    public static String usuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Metodo que sera llamado cuando el usuario haga click en el boton login*/
    public void validarLogin(View view){
        //Intent intent = new Intent(this, DisplayMenuActivity.class);
        Intent intent = new Intent(this, MenuActivity.class);
        //recupera los valores ingresados por el usuario
        EditText editTextUserName = (EditText) findViewById(R.id.editText);
        EditText editTextPassword = (EditText) findViewById(R.id.editText2);
        String message;
        //crea el objeto que realiza la peticion al servidor
        Connection connection = new Connection();
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
            String url = URL_BASE + "/entidades.usuarios/login";
            message = connection.executePost(url, loginParams.toString(), this);
            if (message.equals("") || message == null){
                Toast.makeText(this,"Login fallido", 5).show();
                return;
            }
            //almacena los datos del usuario
            Usuario = new JSONObject(message); //convierte a JSONObject
            IdUsuario = Usuario.getInt("nroUsuario");// recupera el id del usuario
            usuarioActual = Usuario.getString("usuario");



            intent.putExtra(EXTRA_MESSAGE, editTextUserName.getText().toString());
            startActivity(intent);
            finish();
        }
        catch(NullPointerException e){
            Toast.makeText(this,"No se pudo conectar con el servidor", 5).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void registrarse(View view){
        Intent intent = new Intent(this, RegistroUsuarioActivity.class);
        intent.putExtra("padre","login");
        startActivity(intent);
    }

    public void salir(View view){
        System.exit(0);
    }

}