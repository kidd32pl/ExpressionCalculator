package com.kidd32pl.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class AdditionTest
{
    @Test public void testCalculate() throws Exception
    {
        Addition addition = new Addition(new SimpleValue(3), new SimpleValue(5), new SimpleValue(8));

        Integer result = addition.calculate();
        assertEquals(16L, (long)result);
    }

    @Test public void testCalculateNested() throws Exception
    {
        Addition additionNested = new Addition(new SimpleValue(2), new SimpleValue(4));
        Addition addition = new Addition(new SimpleValue(3), additionNested, new SimpleValue(8));

        Integer result = addition.calculate();
        assertEquals(17L, (long)result);
    }

}
