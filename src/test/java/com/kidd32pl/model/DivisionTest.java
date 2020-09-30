package com.kidd32pl.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class DivisionTest
{
    @Test public void testCalculate() throws Exception
    {
        Division division = new Division();
        division.addDividend(new SimpleValue(9));
        division.addDivisor(new SimpleValue(3));

        Integer result = division.calculate();
        assertEquals(3L, (long)result);
    }

    @Test
    public void testCalculateNested() throws Exception
    {
        Division divisionNested = new Division();
        divisionNested.addDividend(new SimpleValue(9));
        divisionNested.addDivisor(new SimpleValue(3));

        Division division = new Division();
        division.addDividend(new SimpleValue(3));
        division.addDivisor(divisionNested);

        Integer result = division.calculate();
        assertEquals(1L, (long)result);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculateException() throws Exception
    {
        Division division = new Division();
        division.addDividend(new SimpleValue(3));
        division.addDivisor(new SimpleValue(0));

        division.calculate();
    }


}
