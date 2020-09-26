package com.kidd32pl.xml;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class SubtractionTest
{
    @Test public void testCalculate() throws Exception
    {
        Subtraction subtraction = new Subtraction();
        subtraction.setMinuend(new SimpleValue(9));
        subtraction.setSubtrahend(new SimpleValue(3));

        Integer result = subtraction.calculate();
        assertEquals(6L, (long)result);
    }

    @Test
    public void testCalculateNested() throws Exception
    {
        Subtraction subtractionNested = new Subtraction();
        subtractionNested.setMinuend(new SimpleValue(9));
        subtractionNested.setSubtrahend(new SimpleValue(3));

        Subtraction subtraction = new Subtraction();
        subtraction.setMinuend(new SimpleValue(12));
        subtraction.setSubtrahend(subtractionNested);

        Integer result = subtraction.calculate();
        assertEquals(6L, (long)result);
    }

}
