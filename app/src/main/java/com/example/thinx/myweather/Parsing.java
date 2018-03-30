package com.example.thinx.myweather;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by ThinX on 14.09.2017.
 */
    public class Parsing {
    public static String LOG_TAG = "my_log";
    private static Wind wind = new Wind();

    public String parserId(JsonObject result) {
//иконка основная
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(0);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }

    public String parserId1(JsonObject result) {
//иконка первая почасовая
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(5);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }

    public String parserId2(JsonObject result) {
//иконка вторая почасовая
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(6);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }
    public String parserId3(JsonObject result) {
//иконка третья почасовая
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(7);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }
    public String parserId4(JsonObject result) {
//иконка четвертая почасовая
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(8);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }
    public String parserId5(JsonObject result) {
//иконка пятая почасовая
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(9);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }

    public String parserId6(JsonObject result) {
//иконка шестая дневная 7.15.23.31.39
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(7);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }
    public String parserId7(JsonObject result) {
//иконка седьмая дневная
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(15);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }
    public String parserId8(JsonObject result) {
//иконка восьмая дневная
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(23);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }
    public String parserId9(JsonObject result) {
//иконка девятая дневная
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(31);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }
    public String parserId10(JsonObject result) {
//иконка десятая дневная
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(39);
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        return id.get("id").getAsString();
    }

    /*public int parserIds(JsonObject result, int idMass){  //парсим иконки для времени дня
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject id1 = (JsonObject) list.get(idMass); //3
        JsonArray id2 = (JsonArray) id1.get("weather");
        JsonObject id = (JsonObject) id2.get(0);
        String ids = id.get("id").getAsString();
        Log.d(LOG_TAG, String.valueOf(ids));
        wind.setIcon1(ids);
        return Integer.parseInt(ids);
    }*/


    public void parserParams(JsonObject result) {
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");//зашел в лист
        Log.d(LOG_TAG, String.valueOf(list));
            JsonObject temp1 = (JsonObject) list.get(0);// зашел в первый лист (0)
            JsonObject temp2 = (JsonObject) temp1.get("main"); //зашел в меин
            String temp = temp2.get("temp").getAsString(); // взял темп
            String humidity = temp2.get("humidity").getAsString();
            Log.d(LOG_TAG, String.valueOf(temp));

// время первое по времени дня  выставил с 9 утра
        JsonObject hour1 = (JsonObject) list.get(5);
        String hour2 = hour1.get("dt_txt").getAsString();
        String hour = hour2.substring(11, 16);
        wind.setHour1(hour);
// время второе по времени дня
        JsonObject hour11 = (JsonObject) list.get(6);
        String hour12 = hour11.get("dt_txt").getAsString();
        String hour13 = hour12.substring(11, 16);
        wind.setHour2(hour13);
// время третье по времени дня
        JsonObject hour21 = (JsonObject) list.get(7);
        String hour22 = hour21.get("dt_txt").getAsString();
        String hour23 = hour22.substring(11, 16);
        wind.setHour3(hour23);
// время четвертое по времени дня
        JsonObject hour31 = (JsonObject) list.get(8);
        String hour32 = hour31.get("dt_txt").getAsString();
        String hour33 = hour32.substring(11, 16);
        wind.setHour4(hour33);
// время пятое по времени дня
        JsonObject hour41 = (JsonObject) list.get(9);
        String hour42 = hour41.get("dt_txt").getAsString();
        String hour43 = hour42.substring(11, 16);
        wind.setHour5(hour43);

            wind.setTemp(temp);
            wind.setHumidity(humidity);
//температура первого дня дневная
        JsonObject temp01 = (JsonObject) list.get(7);
        JsonObject temp02 = (JsonObject) temp01.get("main");
        String temp03 = temp02.get("temp").getAsString();
        wind.setTemp1(temp03);
//температура второго дня дневная
        JsonObject temp21 = (JsonObject) list.get(15);
        JsonObject temp22 = (JsonObject) temp21.get("main");
        String temp23 = temp22.get("temp").getAsString();
        wind.setTemp2(temp23);
//температура третьего дня дневная
        JsonObject temp31 = (JsonObject) list.get(23);
        JsonObject temp32 = (JsonObject) temp31.get("main");
        String temp33 = temp32.get("temp").getAsString();
        wind.setTemp3(temp33);
//температура четвертого дня дневная
        JsonObject temp41 = (JsonObject) list.get(31);
        JsonObject temp42 = (JsonObject) temp41.get("main");
        String temp43 = temp42.get("temp").getAsString();
        wind.setTemp4(temp43);
//температура пятого дня дневная
        JsonObject temp51 = (JsonObject) list.get(39);
        JsonObject temp52 = (JsonObject) temp51.get("main");
        String temp53 = temp52.get("temp").getAsString();
        wind.setTemp5(temp53);
//температура первого дня ночная
        JsonObject temp61 = (JsonObject) list.get(10);
        JsonObject temp62 = (JsonObject) temp61.get("main");
        String temp63 = temp62.get("temp").getAsString();
        wind.setTemp6(temp63);
//температура второго дня ночная
        JsonObject temp71 = (JsonObject) list.get(18);
        JsonObject temp72 = (JsonObject) temp71.get("main");
        String temp73 = temp72.get("temp").getAsString();
        wind.setTemp7(temp73);
//температура третьего дня ночная
        JsonObject temp81 = (JsonObject) list.get(26);
        JsonObject temp82 = (JsonObject) temp81.get("main");
        String temp83 = temp82.get("temp").getAsString();
        wind.setTemp8(temp83);
//температура четвертого дня ночная
        JsonObject temp91 = (JsonObject) list.get(34);
        JsonObject temp92 = (JsonObject) temp91.get("main");
        String temp93 = temp92.get("temp").getAsString();
        wind.setTemp9(temp93);
//температура пятого дня ночная
        JsonObject temp101 = (JsonObject) list.get(35);
        JsonObject temp102 = (JsonObject) temp101.get("main");
        String temp103 = temp102.get("temp").getAsString();
        wind.setTemp10(temp103);

// темпертура первая по времени дня
        JsonObject temp201 = (JsonObject) list.get(5);
        JsonObject temp202 = (JsonObject) temp201.get("main");
        String temp203 = temp202.get("temp").getAsString();
        wind.setTemp21(temp203);
// темпертура вторая по времени дня
        JsonObject temp301 = (JsonObject) list.get(6);
        JsonObject temp302 = (JsonObject) temp301.get("main");
        String temp303 = temp302.get("temp").getAsString();
        wind.setTemp31(temp303);
// темпертура третья по времени дня
        JsonObject temp401 = (JsonObject) list.get(7);
        JsonObject temp402 = (JsonObject) temp401.get("main");
        String temp403 = temp402.get("temp").getAsString();
        wind.setTemp41(temp403);
// темпертура четвертая по времени дня
        JsonObject temp501 = (JsonObject) list.get(8);
        JsonObject temp502 = (JsonObject) temp501.get("main");
        String temp503 = temp502.get("temp").getAsString();
        wind.setTemp51(temp503);
// темпертура пятая по времени дня
        JsonObject temp601 = (JsonObject) list.get(9);
        JsonObject temp602 = (JsonObject) temp601.get("main");
        String temp603 = temp602.get("temp").getAsString();
        wind.setTemp61(temp603);

   // date первого дня
        JsonObject date01 = (JsonObject) list.get(7);
        String date03 = date01.get("dt_txt").getAsString();
        String date04 = date03.substring(5,10);
        wind.setDate1(date04);
// date второго дня
        JsonObject date11 = (JsonObject) list.get(15);
        String date13 = date11.get("dt_txt").getAsString();
        String date14 = date13.substring(5,10);
        wind.setDate2(date14);
// date третьего дня
        JsonObject date21 = (JsonObject) list.get(23);
        String date23 = date21.get("dt_txt").getAsString();
        String date24 = date23.substring(5,10);
        wind.setDate3(date24);
// date четвертого дня
        JsonObject date31 = (JsonObject) list.get(31);
        String date33 = date31.get("dt_txt").getAsString();
        String date34 = date33.substring(5,10);
        wind.setDate4(date34);
// date пятого дня
        JsonObject date41 = (JsonObject) list.get(39);
        String date43 = date41.get("dt_txt").getAsString();
        String date44 = date43.substring(5,10);
        wind.setDate5(date44);

    }

    public void parserWind(JsonObject result){
        JsonObject jobject = result.getAsJsonObject();
        JsonArray list = (JsonArray) jobject.get("list");
        JsonObject wind1 = (JsonObject) list.get(0);
        JsonObject wind2 = (JsonObject) wind1.get("wind");
       // Log.d(LOG_TAG, String.valueOf(wind1));
        String windSpeed = wind2.get("speed").getAsString();
        wind.setWind(windSpeed);

        JsonObject wind11 = (JsonObject) list.get(7);
        JsonObject wind12 = (JsonObject) wind11.get("wind");
        // Log.d(LOG_TAG, String.valueOf(wind1));
        String windSpeed1 = wind12.get("speed").getAsString();
        wind.setWind1(windSpeed1);

        JsonObject wind21 = (JsonObject) list.get(15);
        JsonObject wind22 = (JsonObject) wind21.get("wind");
        // Log.d(LOG_TAG, String.valueOf(wind1));
        String windSpeed2 = wind22.get("speed").getAsString();
        wind.setWind2(windSpeed2);

        JsonObject wind31 = (JsonObject) list.get(23);
        JsonObject wind32 = (JsonObject) wind31.get("wind");
        // Log.d(LOG_TAG, String.valueOf(wind1));
        String windSpeed3 = wind32.get("speed").getAsString();
        wind.setWind3(windSpeed3);

        JsonObject wind41 = (JsonObject) list.get(31);
        JsonObject wind42 = (JsonObject) wind41.get("wind");
        // Log.d(LOG_TAG, String.valueOf(wind1));
        String windSpeed4 = wind42.get("speed").getAsString();
        wind.setWind4(windSpeed4);

        JsonObject wind51 = (JsonObject) list.get(39);
        JsonObject wind52 = (JsonObject) wind51.get("wind");
        // Log.d(LOG_TAG, String.valueOf(wind1));
        String windSpeed5 = wind52.get("speed").getAsString();
        wind.setWind5(windSpeed5);
    }
    }


