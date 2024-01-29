package org.example.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class City {

    public List<String> getCity(String city) {
        String cityToUppercase = city.toUpperCase();
        if (cityToUppercase.length() < 2) {
            throw new NullPointerException("La recherche a seulement 2 caractères");
        }
        if (cityToUppercase.length() > 2 || cityToUppercase.length() == 2) {
            List<String> cityList = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");
            for (String ci: cityList
                 ) {
                ci.toUpperCase();
            }
            List<String> cityContains = new ArrayList<>();
            for (String c : cityList
            ) {
                if (c.startsWith(city)) {
                    cityContains.add(c);
                }

            }
            return cityContains;
        }
        return null;
    }


}
