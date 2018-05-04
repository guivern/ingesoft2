package com.example.guiver.proyectois2;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class MenuUsuariosActivity extends AppCompatActivity {
    Connection connection = new Connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuarios);

    }

    public void listar(View view) throws JSONException {


        String url = MainActivity.URL_BASE + "/entidades.usuarios";
        JSONArray usuariosJSON = connection.executeGetJSON(url, this);

        String usuarios ="";
        String passwords="";

        for(int i=0; i<usuariosJSON.length(); i++)
        {
            JSONObject obj = usuariosJSON.getJSONObject(i);

            String nombre = obj.getString("usuario");
            String pwd = obj.getString("password");
            usuarios += nombre +"\n";
            passwords += pwd +"\n";
        }
        Intent intent = new Intent(this, ListaUsuariosActivity.class);
        intent.putExtra("usuario", usuarios);
        intent.putExtra("pass", passwords);
        startActivity(intent);

    }

    public void agregar(View view){

        Intent intent = new Intent(this, RegistroUsuarioActivity.class);
        startActivity(intent);
    }

    public void editar(View view) throws JSONException {
        //Toast.makeText(this,"En construcción", 5).show();
        /*Intent intent = new Intent(this, EditarUsuarioActivity.class);
        startActivity(intent);*/
        String url = MainActivity.URL_BASE + "/entidades.usuarios";
        JSONArray usuariosJSON = connection.executeGetJSON(url, this);

        String usuarios ="";
        String ids="";

        for(int i=0; i<usuariosJSON.length(); i++)
        {
            JSONObject obj = usuariosJSON.getJSONObject(i);

            String nombre = obj.getString("usuario");
            String id = obj.getString("nroUsuario");
            usuarios += nombre +"\n";
            ids += id +"\n";
        }
        Intent intent = new Intent(this, EditarUsuarioActivity.class);
        intent.putExtra("usuario", usuarios);
        intent.putExtra("ids", ids);
        startActivity(intent);
    }

    public void eliminar(View view) throws JSONException{
        String url = MainActivity.URL_BASE + "/entidades.usuarios";
        JSONArray usuariosJSON = connection.executeGetJSON(url, this);

        String usuarios ="";
        String ids="";

        for(int i=0; i<usuariosJSON.length(); i++)
        {
            JSONObject obj = usuariosJSON.getJSONObject(i);

            String nombre = obj.getString("usuario");
            String id = obj.getString("nroUsuario");
            usuarios += nombre +"\n";
            ids += id +"\n";
        }
        Intent intent = new Intent(this, EliminarUsuarioActivity.class);
        intent.putExtra("usuario", usuarios);
        intent.putExtra("ids", ids);
        startActivity(intent);

    }
}
