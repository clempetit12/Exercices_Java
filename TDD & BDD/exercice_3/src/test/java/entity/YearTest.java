package entity;

import org.example.entity.Bissextile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YearTest {

    @Test
    void testIfYearIsDivisibleBy400() {
        Bissextile bissextile = new Bissextile();
        boolean res = bissextile.isDivisibleBy400(2000);
        Assertions.assertTrue(res);


    }
    @Test
    void testIfYearIsDivisibleBy4ButNotBy100() {
        Bissextile bissextile = new Bissextile();
        boolean res = bissextile.isDivisibleBy4ButNot100(2020);
        Assertions.assertTrue(res);


    }


    @Test
    void testIfYearIsDivisibleBy4000() {
        Bissextile bissextile = new Bissextile();
        boolean res = bissextile.isDivisibleBy4000(2020);
        Assertions.assertTrue(res);


    }




}
