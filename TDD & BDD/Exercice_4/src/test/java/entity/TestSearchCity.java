package entity;

import org.example.entity.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestSearchCity {




    @Test
    void TestSearchCityWhereThereIsLessThan2Characters( ) {
        City city = new City();
        String cityName = "a";
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            //Act
          city.searchCity(cityName);
        });



    }
    @Test
    void TestSearchCityWhereThereIsMoreOrEqualsTo2Characters() {
        City city1 = new City();
        String cityName = "Va";
        List<String > result = city1.searchCity(cityName);
        Assertions.assertEquals(Arrays.asList("Valence","Vancouver"),result);
        };

    //3. La fonctionnalité de recherche doit être insensible à la casse

    @Test
    void TestSearchCityNotDependentToCase() {
        City city1 = new City();
        String cityName = "VA";
        List<String > result = city1.searchCity(cityName);
        Assertions.assertEquals(Arrays.asList("Valence","Vancouver"),result);

    }

//    4. La fonctionnalité de recherche devrait également fonctionner lorsque le texte de recherche n'est qu'une partie d'un nom de ville
//    Par exemple "ape" devrait renvoyer la ville "Budapest"

    @Test
    void TestSearchCityWorksWithPartialText() {
        City city1 = new City();
        String cityName = "ape";

        List<String > result = city1.searchCity(cityName);
        Assertions.assertEquals(Arrays.asList("Budapest"),result);

    }

    @Test
    void TestSearchCityWithStarDisplayAllTowns() {
        City city1 = new City();
        String cityName = "*";
        List<String> listExpected = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");
        List<String > result = city1.searchCity(cityName);
        Assertions.assertEquals(listExpected,result);

    }
    
    }

