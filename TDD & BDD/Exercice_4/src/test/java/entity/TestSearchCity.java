package entity;

import org.example.entity.City;
import org.junit.jupiter.api.Assertions;
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
          city.getCity(cityName);
        });



    }
    @Test
    void TestSearchCityWhereThereIsMoreOrEqualsTo2Characters() {
        City city1 = new City();
        String cityName = "Va";
        List<String > result = city1.getCity(cityName);
        Assertions.assertEquals(Arrays.asList("Valence","Vancouver"),result);
        };

    //3. La fonctionnalité de recherche doit être insensible à la casse

    @Test
    void TestSearchCityNotDependentToCase() {
        City city1 = new City();
        String cityName = "VA";
        List<String > result = city1.getCity(cityName);
        Assertions.assertEquals(Arrays.asList("Valence","Vancouver"),result);

    }

    }

