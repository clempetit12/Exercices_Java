package entity;

import org.example.entity.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FibTest {

    private List<Integer> fibInit(int range) {
        Fib fib = new Fib(range);
        List<Integer> result = fib.getFibSeries();
        return result;
    }

    @Test
    void testGetFibSeriesRage1IsNotEmpty() {
        List<Integer> result = fibInit(1);
       boolean res = result.isEmpty();
       Assertions.assertFalse(res);

    }

    @Test
    void testGetFibSeriesRange1IsEqualTo0() {
        List<Integer> result = fibInit(1);
        List<Integer> resultExpected = Arrays.asList(0);
        Assertions.assertEquals(resultExpected, result);

    }


    @Test
    void testGetFibSeriesRange6Contains3() {
        List<Integer> result = fibInit(6);
        Assertions.assertTrue(result.contains(3));

    }

    @Test
    void testGetFibSeriesRange6issEqual6Elements() {
        List<Integer> result = fibInit(6);
        Assertions.assertEquals(6, result.size());


    }

    @Test
    void testGetFibSeriesRange6NotContains4() {
        List<Integer> result = fibInit(6);
        Assertions.assertFalse(result.contains(4));


    }

    @Test
    void testGetFibSeriesRange6EqualsList() {
        List<Integer> result = fibInit(6);
        List<Integer> expectedList = Arrays.asList(0, 1, 1, 2, 3, 5);
        Assertions.assertEquals(expectedList, result);


    }

    @Test
    void testGetFibSeriesRange6ResultSortedAsc() {
        List<Integer> result = fibInit(6);
        Assertions.assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5),result);


    }



}
