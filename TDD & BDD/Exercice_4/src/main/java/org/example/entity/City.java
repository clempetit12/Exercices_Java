package org.example.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class City {

    public List<String> searchCity(String city) {
        String cityToUppercase = city.toUpperCase();
        List<String> cityList = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");
        if ( city == "*") {

            return   cityList;}
        else if (cityToUppercase.length() < 2) {
            throw new NullPointerException("La recherche a seulement 2 caractères");
        }
        else if (cityToUppercase.length() > 2 || cityToUppercase.length() == 2) {


            List<String> cityContains = new ArrayList<>();
            for (String c : cityList) {
                if(c.toUpperCase().contains(cityToUppercase)){
                    cityContains.add(c);
                }

            }
            return cityContains;
        }
        return null;
    }


}
