package com.example.guiver.proyectois2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MenuTareasActivity extends AppCompatActivity {
    Connection connection = new Connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tareas);

    }
    public void listar(View view) throws JSONException {

        String url = MainActivity.URL_BASE + "/entidades.tareas";
        JSONArray tareasJSON = connection.executeGetJSON(url, this);

        String tareas ="";
        String idTareas="";
        String estados="";
        String fechas="";
        String usuarios="";
        int cont = 0;

        for(int i=0; i<tareasJSON.length(); i++)
        {
            JSONObject obj = tareasJSON.getJSONObject(i);

            String tarea = obj.getString("titulo");
            String idTarea = obj.getString("nroTarea");
            String fecha = obj.getString("fechaFin").substring(0,10);
            String estado = obj.getJSONObject("tareaNroEstado").getString("estado");
            String usuario = obj.getJSONObject("nroUsuarioFk").getString("usuario");
            int idUser = obj.getJSONObject("nroUsuarioFk").getInt("nroUsuario");


            String usuarioActual = MainActivity.Usuario.get("usuario").toString();

            if(usuarioActual.equals(MainActivity.usuarioAdmin)){//si es Admin
                //Recupera todas las tareas para el usuario admin
                tareas += tarea +"\n";
                idTareas += idTarea +"\n";
                estados += estado + "\n";
                fechas += fecha + "\n";
                usuarios += usuario + "\n";
                cont++;
            }
            else if(MainActivity.IdUsuario == idUser){//no es Admin
                //solo recupera las tareas que pertenecen al usuario actual
                tareas += tarea +"\n";
                idTareas += idTarea +"\n";
                estados += estado + "\n";
                fechas += fecha + "\n";
                cont++;
            }
        }
        Intent intent = new Intent(this, ListaTareasActivity.class);
        intent.putExtra("tarea", tareas);
        intent.putExtra("id", idTareas);
        intent.putExtra("fec", fechas);
        intent.putExtra("estado", estados);
        intent.putExtra("cont", cont);
        intent.putExtra("usuario", usuarios);
        startActivity(intent);

    }

    public void agregar(View view){

        Intent intent = new Intent(this, RegistroTareaActivity.class);
        startActivity(intent);

    }

    public void editar(View view) throws JSONException {

        String url = MainActivity.URL_BASE + "/entidades.tareas";
        JSONArray tareasJSON = connection.executeGetJSON(url, this);

        String tareas ="";
        String ids="";
        int idUser;

        for(int i=0; i<tareasJSON.length(); i++)
        {
            JSONObject obj = tareasJSON.getJSONObject(i);

            String titulo = obj.getString("titulo");
            String id = obj.getString("nroTarea");
             idUser= obj.getJSONObject("nroUsuarioFk").getInt("nroUsuario");

             //solo recupera las tareas que pertenecen al usuario actual
            if(MainActivity.IdUsuario == idUser) {
                tareas += titulo + "\n";
                ids += id + "\n";
            }
        }
        Intent intent = new Intent(this, EditarTareaActivity.class);
        intent.putExtra("tareas", tareas);
        intent.putExtra("ids", ids);
        startActivity(intent);

    }

    public void eliminar(View view) throws JSONException{

        String url = MainActivity.URL_BASE + "/entidades.tareas";
        JSONArray tareasJSON = connection.executeGetJSON(url, this);

        String tareas ="";
        String idTareas="";

        for(int i=0; i<tareasJSON.length(); i++)
        {
            JSONObject obj = tareasJSON.getJSONObject(i);

            String tarea = obj.getString("titulo");
            String idTarea = obj.getString("nroTarea");
            int idUser = obj.getJSONObject("nroUsuarioFk").getInt("nroUsuario");
            //solo recupera las tareas que pertenecen al usuario actual
            if(MainActivity.IdUsuario == idUser){
                tareas += tarea +"\n";
                idTareas += idTarea +"\n";
            }
        }
        Intent intent = new Intent(this, EliminarTareaActivity.class);
        intent.putExtra("tarea", tareas);
        intent.putExtra("id", idTareas);
        startActivity(intent);
    }

    public void estado(View view) throws JSONException {

        String url = MainActivity.URL_BASE + "/entidades.tareas";
        JSONArray tareasJSON = connection.executeGetJSON(url, this);

        String tareas ="";
        String idTareas="";
        String estados="";

        for(int i=0; i<tareasJSON.length(); i++)
        {
            JSONObject obj = tareasJSON.getJSONObject(i);

            String tarea = obj.getString("titulo");
            String idTarea = obj.getString("nroTarea");
            String estado = obj.getJSONObject("tareaNroEstado").getString("estado");
            int idUser = obj.getJSONObject("nroUsuarioFk").getInt("nroUsuario");
            //solo recupera las tareas que pertenecen al usuario actual
            if(MainActivity.IdUsuario == idUser){
                tareas += tarea +"\n";
                idTareas += idTarea +"\n";
                estados += estado + "\n";
            }
        }
        Intent intent = new Intent(this, CambiarEstadoActivity.class);
        intent.putExtra("tarea", tareas);
        intent.putExtra("id", idTareas);
        intent.putExtra("estado", estados);
        startActivity(intent);

    }

}
