package com.kidd32pl.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class MultiplicationTest
{
    @Test public void testCalculate() throws Exception
    {
        Multiplication multiplication = new Multiplication(new SimpleValue(3), new SimpleValue(5), new SimpleValue(8));

        Integer result = multiplication.calculate();
        assertEquals(120L, (long)result);
    }

    @Test public void testCalculateNested() throws Exception
    {
        Multiplication multiplicationNested = new Multiplication(new SimpleValue(2), new SimpleValue(4));
        Multiplication multiplication = new Multiplication(new SimpleValue(3), multiplicationNested, new SimpleValue(8));

        Integer result = multiplication.calculate();
        assertEquals(192L, (long)result);
    }

}
