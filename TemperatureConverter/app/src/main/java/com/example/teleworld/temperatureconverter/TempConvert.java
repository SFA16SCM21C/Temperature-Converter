package com.example.teleworld.temperatureconverter;

import java.text.DecimalFormat;

/**
 * Created by teleworld on 1/27/2017.
 */

public class TempConvert {
    //function to convert fahrenheit to celsius
    public static double fahrenheit_celsius(double f){

        double c = (f-32)*5/9;
        DecimalFormat fc = new DecimalFormat("#.#");
        return Double.parseDouble(fc.format(c));
    }

    //function to convert celsius to fahrenheit
    public static double celsius_fahrenheit(double c){

        double f = 32+(c*9/5);
        DecimalFormat cf = new DecimalFormat("#.#");
        return Double.parseDouble(cf.format(f));
    }
}
