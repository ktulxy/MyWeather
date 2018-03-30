package com.example.thinx.myweather;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ThinX on 14.09.2017.
 */

public class ConnectApi {

    public JsonObject connect(String city) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String url = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&APPID=693bc5884d2a585cdb170d137f0da55a&units=metric";
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String A = String.valueOf(response);
        JsonElement jelement = new JsonParser().parse(A);
        return (JsonObject) jelement;
    }

}
