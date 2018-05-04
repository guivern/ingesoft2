package com.example.guiver.proyectois2;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by guiver on 30/04/18.
 */

public class Connection {
    int timeout;
    URL url;
    HttpURLConnection connection;

    public Connection() {
        this.timeout = 5000;
        this.url = null;
        this.connection = null;
    }

    //Envia una peticion al servidor a traves del metodo GET
    public String executeGet(String targetURL, Context context) {

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
            Toast.makeText(context,e.toString(), 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    //Envia una peticion al servidor a traves del metodo GET, retorna un JSONArray
    public JSONArray executeGetJSON(String targetURL, Context context) {

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
            JSONArray respJSON = new JSONArray(response.toString());
            return respJSON;

        } catch (Exception e) {
            Toast.makeText(context,e.toString(), 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    //Envia una peticion al servidor a traves del metodo POST
    public String executePost(String targetURL, String urlParameters, Context context) {

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
            Toast.makeText(context,"Error de conexión", 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    //Envia una peticion al servidor a traves del metodo PUT
    public String executePut(String targetURL,String urlParameters, Context context) {

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
            Toast.makeText(context,"Error de conexión.", 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    //Envia una peticion al servidor a traves del metodo DELETE
    public String executeDelete(String targetURL, Context context) {

        try {
            //establece la conexion

            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");


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
            Toast.makeText(context,"Algo salió mal.", 10).show();
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

}
