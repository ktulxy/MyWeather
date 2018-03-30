package com.example.thinx.myweather;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;

import static com.example.thinx.myweather.R.array;
import static com.example.thinx.myweather.R.drawable;
import static com.example.thinx.myweather.R.id;
import static com.example.thinx.myweather.R.layout;

public class MainActivity extends AppCompatActivity{
    private static String city23 = "Kiev";
    static Wind wind = new Wind();
    Weather weather = new Weather();
    int currentItem = 0;

    TextView cityTemp, tempNow, windNow, humidityNow,  tempFirst, tempTwo, tempThree,tempFour, tempFive, tempFirstN, tempTwoN, tempThreeN, tempFourN, tempFiveN, windFirst, windTwo,
            windThree, windFour, windFive, tempNow1, tempNow2, tempNow3, tempNow4, tempNow5, hour1, hour2, hour3, hour4, hour5,
            date1, date2, date3, date4, date5;

    ImageView Icons, imageHour1, imageHour2, imageHour3, imageHour4, imageHour5, imageHour6, imageHour7, imageHour8, imageHour9, imageHour10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        cityTemp = (TextView) findViewById(id.cityTemp);
        tempNow = (TextView) findViewById(id.tempNow);
        Icons = (ImageView) findViewById(id.imageViewSunDay);
        windNow = (TextView) findViewById(id.wind);
        humidityNow = (TextView) findViewById(id.humidity);
        weather.execute();
       // input = (TextView) findViewById(R.id.input);
        tempFirst = (TextView) findViewById(id.text1);
        tempTwo = (TextView) findViewById(id.text2);
        tempThree = (TextView) findViewById(id.text3);
        tempFour = (TextView) findViewById(id.text4);
        tempFive = (TextView) findViewById(id.text5);
        tempFirstN = (TextView) findViewById(id.textView6);
        tempTwoN = (TextView) findViewById(id.textView7);
        tempThreeN = (TextView) findViewById(id.textView8);
        tempFourN = (TextView) findViewById(id.textView9);
        tempFiveN = (TextView) findViewById(id.textView10);
        windFirst = (TextView) findViewById(id.textView16);
        windTwo = (TextView) findViewById(id.textView17);
        windThree = (TextView) findViewById(id.textView18);
        windFour = (TextView) findViewById(id.textView19);
        windFive = (TextView) findViewById(id.textView20);
        tempNow1 = (TextView) findViewById(id.textView21);
        tempNow2 = (TextView) findViewById(id.textView22);
        tempNow3 = (TextView) findViewById(id.textView23);
        tempNow4 = (TextView) findViewById(id.textView24);
        tempNow5 = (TextView) findViewById(id.textView25);
        hour1 = (TextView) findViewById(id.textView);
        hour2 = (TextView) findViewById(id.textView2);
        hour3 = (TextView) findViewById(id.textView3);
        hour4 = (TextView) findViewById(id.textView4);
        hour5 = (TextView) findViewById(id.textView5);
        date1 = (TextView) findViewById(id.textView11);
        date2 = (TextView) findViewById(id.textView12);
        date3 = (TextView) findViewById(id.textView13);
        date4 = (TextView) findViewById(id.textView14);
        date5 = (TextView) findViewById(id.textView15);
        imageHour1 = (ImageView) findViewById(id.imageView);
        imageHour2 = (ImageView) findViewById(id.imageView2);
        imageHour3 = (ImageView) findViewById(id.imageView3);
        imageHour4 = (ImageView) findViewById(id.imageView4);
        imageHour5 = (ImageView) findViewById(id.imageView5);
        imageHour6 = (ImageView) findViewById(id.imageView6);
        imageHour7 = (ImageView) findViewById(id.imageView7);
        imageHour8 = (ImageView) findViewById(id.imageView8);
        imageHour9 = (ImageView) findViewById(id.imageView9);
        imageHour10 = (ImageView) findViewById(id.imageView10);

        //доступ к RAW
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.mycity));

        final AutoCompleteTextView simpleAutoCompleteTextView = (AutoCompleteTextView) findViewById(id.aCTV);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(array.mycity));
        simpleAutoCompleteTextView.setThreshold(3);
        simpleAutoCompleteTextView.setAdapter(adapter);
        simpleAutoCompleteTextView.getAdapter();

        simpleAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String InputCity = String.valueOf(parent.getItemAtPosition(position));
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(simpleAutoCompleteTextView.getWindowToken(), 0);



                if (currentItem == position) {
                  city23 = InputCity;
                  new Weather().execute();

                }
            }
        });
    }



  //  public void chekVersion(MenuItem item){
    /*    versia.setText("Версия 1.6");
    }*/

    class Weather extends AsyncTask<Void, Void, JsonObject> {

        @Override
        public void onPreExecute() {
            super.onPreExecute();
            cityTemp.setText("Погода в городе  " + city23);
        }

        @Override
        public JsonObject doInBackground(Void... params) {
            return new ConnectApi().connect(city23);

        }

        @Override
        public void onPostExecute(JsonObject result) {
            super.onPostExecute(result);

            new Parsing().parserParams(result);
            tempNow.setText(wind.getTemp() + " °");
            tempFirst.setText("☼" + wind.getTemp1() + " °" ); // погода на первый день
            tempTwo.setText(wind.getTemp2() + " °"); // погода на второй день
            tempThree.setText(wind.getTemp3() + " °"); // погода 3 день
            tempFour.setText(wind.getTemp4() + " °"); // погода 4 день
            tempFive.setText(wind.getTemp5() + " °"); // погода 5 день
            tempFirstN.setText(wind.getTemp6() + " °"); // погода на первый день
            tempTwoN.setText(wind.getTemp7() + " °"); // погода на второй день
            tempThreeN.setText(wind.getTemp8() + " °"); // погода 3 день
            tempFourN.setText(wind.getTemp9() + " °"); // погода 4 день
            tempFiveN.setText(wind.getTemp10() + " °"); // погода 5 день
            tempNow1.setText(wind.getTemp11() + " °");
            tempNow2.setText(wind.getTemp12() + " °");
            tempNow3.setText(wind.getTemp13() + " °");
            tempNow4.setText(wind.getTemp14() + " °");
            tempNow5.setText(wind.getTemp15() + " °");
            hour1.setText(wind.getHour1());
            hour2.setText(wind.getHour2());
            hour3.setText(wind.getHour3());
            hour4.setText(wind.getHour4());
            hour5.setText(wind.getHour5());
            date1.setText(wind.getDate1());
            date2.setText(wind.getDate2());
            date3.setText(wind.getDate3());
            date4.setText(wind.getDate4());
            date5.setText(wind.getDate5());

          //  new Parsing().parserIds(result, 3);
            // imageHour1.setImageResource(wind.getIcon1()drawable.thunderstorm);


            humidityNow.setText("Влажность " + wind.getHumidity() + "%");

            new Parsing().parserWind(result);
            windNow.setText("Ветер " + wind.getWind() + " м/с");
            windFirst.setText(wind.getWind1() + " м/с");
            windTwo.setText(wind.getWind2() + " м/с");
            windThree.setText(wind.getWind3() + " м/с");
            windFour.setText(wind.getWind4() + " м/с");
            windFive.setText(wind.getWind5() + " м/с");


            /*//5 / 7 / 9
            int[] mass = new int[5];
            mass[0] = 3;
            mass[1] = 4;
            mass[2] = 5;
            mass[3] = 6;
            mass[4] = 7;
             for (int i = 0; i < 5; i++) {
            if ((new Parsing().parserIds(result, mass[i])) <= 250) {

                //if (idWeather <= 250) {

                    //Icons.setImageResource(drawable.thunderstorm);
                    *//*imageHour1.setImageResource(drawable.thunderstorm);
                    imageHour2.setImageResource(drawable.thunderstorm);
                    imageHour3.setImageResource(drawable.thunderstorm);
                    imageHour4.setImageResource(drawable.thunderstorm);
                    imageHour5.setImageResource(drawable.thunderstorm);*//*
                    if (i==0)      imageHour1.setImageResource(drawable.thunderstorm);
                    if (i==1)       imageHour2.setImageResource(drawable.thunderstorm);

                } else if ((new Parsing().parserIds(result, mass[i])) <= 350) {
                   // Icons.setImageResource(drawable.showerrain);
                    imageHour1.setImageResource(drawable.showerrain);
                    imageHour2.setImageResource(drawable.showerrain);
                    imageHour3.setImageResource(drawable.showerrain);
                    imageHour4.setImageResource(drawable.showerrain);
                    imageHour5.setImageResource(drawable.showerrain);

                } else if ((new Parsing().parserIds(result, mass[i])) <= 550) {
                    //Icons.setImageResource(drawable.rain);
                    imageHour1.setImageResource(drawable.rain);
                    imageHour2.setImageResource(drawable.rain);
                    imageHour3.setImageResource(drawable.rain);
                    imageHour4.setImageResource(drawable.rain);
                    imageHour5.setImageResource(drawable.rain);
                    //  imageHour1.setImageResource();
                } else if ((new Parsing().parserIds(result, mass[i])) <= 650) {
                   // Icons.setImageResource(drawable.snow);
                    imageHour1.setImageResource(drawable.snow);
                    imageHour2.setImageResource(drawable.snow);
                    imageHour3.setImageResource(drawable.snow);
                    imageHour4.setImageResource(drawable.snow);
                    imageHour5.setImageResource(drawable.snow);
                } else if ((new Parsing().parserIds(result, mass[i])) <= 750) {
                    //Icons.setImageResource(drawable.mist);
                    imageHour1.setImageResource(drawable.mist);
                    imageHour2.setImageResource(drawable.mist);
                    imageHour3.setImageResource(drawable.mist);
                    imageHour4.setImageResource(drawable.mist);
                    imageHour5.setImageResource(drawable.mist);
                } else
                   // Icons.setImageResource(drawable.clearsky);
                    imageHour1.setImageResource(drawable.clearsky);
                    imageHour2.setImageResource(drawable.clearsky);
                    imageHour3.setImageResource(drawable.clearsky);
                    imageHour4.setImageResource(drawable.clearsky);
                    imageHour5.setImageResource(drawable.clearsky);
            }*/

            int idWeather1 = Integer.parseInt(new Parsing().parserId1(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather1 <= 250) {
                    imageHour1.setImageResource(drawable.thunderstorm);
                } else if (idWeather1 <= 350) {
                    imageHour1.setImageResource(drawable.showerrain);
                } else if (idWeather1 <= 550) {
                    imageHour1.setImageResource(drawable.rain);
                } else if (idWeather1 <= 650) {
                    imageHour1.setImageResource(drawable.snow);
                } else if (idWeather1 <= 750) {
                    imageHour1.setImageResource(drawable.mist);
                } else
                    imageHour1.setImageResource(drawable.clearsky);
            }
            int idWeather2 = Integer.parseInt(new Parsing().parserId2(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather2 <= 250) {
                    imageHour2.setImageResource(drawable.thunderstorm);
                } else if (idWeather2 <= 350) {
                    imageHour2.setImageResource(drawable.showerrain);
                } else if (idWeather2 <= 550) {
                    imageHour2.setImageResource(drawable.rain);
                } else if (idWeather2 <= 650) {
                    imageHour2.setImageResource(drawable.snow);
                } else if (idWeather2 <= 750) {
                    imageHour2.setImageResource(drawable.mist);
                } else
                    imageHour2.setImageResource(drawable.clearsky);
            }
            int idWeather3 = Integer.parseInt(new Parsing().parserId3(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather3 <= 250) {
                    imageHour3.setImageResource(drawable.thunderstorm);
                } else if (idWeather3 <= 350) {
                    imageHour3.setImageResource(drawable.showerrain);
                } else if (idWeather3 <= 550) {
                    imageHour3.setImageResource(drawable.rain);
                } else if (idWeather3 <= 650) {
                    imageHour3.setImageResource(drawable.snow);
                } else if (idWeather3 <= 750) {
                    imageHour3.setImageResource(drawable.mist);
                } else
                    imageHour3.setImageResource(drawable.clearsky);
            }
            int idWeather4 = Integer.parseInt(new Parsing().parserId4(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather4 <= 250) {
                    imageHour4.setImageResource(drawable.thunderstorm);
                } else if (idWeather4 <= 350) {
                    imageHour4.setImageResource(drawable.showerrain);
                } else if (idWeather4 <= 550) {
                    imageHour4.setImageResource(drawable.rain);
                } else if (idWeather4 <= 650) {
                    imageHour4.setImageResource(drawable.snow);
                } else if (idWeather4 <= 750) {
                    imageHour4.setImageResource(drawable.mist);
                } else
                    imageHour4.setImageResource(drawable.clearsky);
            }
            int idWeather5 = Integer.parseInt(new Parsing().parserId5(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather5 <= 250) {
                    imageHour5.setImageResource(drawable.thunderstorm);
                } else if (idWeather5 <= 350) {
                    imageHour5.setImageResource(drawable.showerrain);
                } else if (idWeather5 <= 550) {
                    imageHour5.setImageResource(drawable.rain);
                } else if (idWeather5 <= 650) {
                    imageHour5.setImageResource(drawable.snow);
                } else if (idWeather5 <= 750) {
                    imageHour5.setImageResource(drawable.mist);
                } else
                    imageHour5.setImageResource(drawable.clearsky);
            }
            int idWeather = Integer.parseInt(new Parsing().parserId(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather <= 250) {
                    Icons.setImageResource(drawable.thunderstorm);
                } else if (idWeather <= 350) {
                    Icons.setImageResource(drawable.showerrain);
                } else if (idWeather <= 550) {
                    Icons.setImageResource(drawable.rain);
                } else if (idWeather <= 650) {
                    Icons.setImageResource(drawable.snow);
                } else if (idWeather <= 750) {
                    Icons.setImageResource(drawable.mist);
                } else
                    Icons.setImageResource(drawable.clearsky);
            }

            int idWeather6 = Integer.parseInt(new Parsing().parserId10(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather6 <= 250) {
                    imageHour6.setImageResource(drawable.thunderstorm);
                } else if (idWeather6 <= 350) {
                    imageHour6.setImageResource(drawable.showerrain);
                } else if (idWeather6 <= 550) {
                    imageHour6.setImageResource(drawable.rain);
                } else if (idWeather6 <= 650) {
                    imageHour6.setImageResource(drawable.snow);
                } else if (idWeather6 <= 750) {
                    imageHour6.setImageResource(drawable.mist);
                } else
                    imageHour6.setImageResource(drawable.clearsky);
            }
            int idWeather7 = Integer.parseInt(new Parsing().parserId9(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather7 <= 250) {
                    imageHour7.setImageResource(drawable.thunderstorm);
                } else if (idWeather7 <= 350) {
                    imageHour7.setImageResource(drawable.showerrain);
                } else if (idWeather7 <= 550) {
                    imageHour7.setImageResource(drawable.rain);
                } else if (idWeather7 <= 650) {
                    imageHour7.setImageResource(drawable.snow);
                } else if (idWeather7 <= 750) {
                    imageHour7.setImageResource(drawable.mist);
                } else
                    imageHour7.setImageResource(drawable.clearsky);
            }
            int idWeather8 = Integer.parseInt(new Parsing().parserId8(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather8 <= 250) {
                    imageHour8.setImageResource(drawable.thunderstorm);
                } else if (idWeather8 <= 350) {
                    imageHour8.setImageResource(drawable.showerrain);
                } else if (idWeather8 <= 550) {
                    imageHour8.setImageResource(drawable.rain);
                } else if (idWeather8 <= 650) {
                    imageHour8.setImageResource(drawable.snow);
                } else if (idWeather8 <= 750) {
                    imageHour8.setImageResource(drawable.mist);
                } else
                    imageHour8.setImageResource(drawable.clearsky);
            }
            int idWeather9 = Integer.parseInt(new Parsing().parserId7(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather9 <= 250) {
                    imageHour9.setImageResource(drawable.thunderstorm);
                } else if (idWeather9 <= 350) {
                    imageHour9.setImageResource(drawable.showerrain);
                } else if (idWeather9 <= 550) {
                    imageHour9.setImageResource(drawable.rain);
                } else if (idWeather9 <= 650) {
                    imageHour9.setImageResource(drawable.snow);
                } else if (idWeather9 <= 750) {
                    imageHour9.setImageResource(drawable.mist);
                } else
                    imageHour9.setImageResource(drawable.clearsky);
            }
            int idWeather10 = Integer.parseInt(new Parsing().parserId6(result));
            for (int i = 0; i < 5; i++) {
                if (idWeather10 <= 250) {
                    imageHour10.setImageResource(drawable.thunderstorm);
                } else if (idWeather10 <= 350) {
                    imageHour10.setImageResource(drawable.showerrain);
                } else if (idWeather10 <= 550) {
                    imageHour10.setImageResource(drawable.rain);
                } else if (idWeather10 <= 650) {
                    imageHour10.setImageResource(drawable.snow);
                } else if (idWeather10 <= 750) {
                    imageHour10.setImageResource(drawable.mist);
                } else
                    imageHour10.setImageResource(drawable.clearsky);
            }
        }


    }


}





