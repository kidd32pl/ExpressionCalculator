package com.kidd32pl;

import com.kidd32pl.xml.Addition;
import com.kidd32pl.xml.Division;
import com.kidd32pl.xml.Expressions;
import com.kidd32pl.xml.Multiplication;
import com.kidd32pl.xml.Result;
import com.kidd32pl.xml.SimpleValue;
import com.kidd32pl.xml.Subtraction;
import org.junit.Test;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class ExpressionCalculatorTest
{
    @Test
    public void testNordeaSimpleCase()
    {
        Addition addition = new Addition(new SimpleValue(2), new SimpleValue(3), new SimpleValue(4));
        addition.setId("1");

        Subtraction subtraction = new Subtraction();
        subtraction.setId("2");
        subtraction.setMinuend(new SimpleValue(3));
        subtraction.setSubtrahend(new SimpleValue(2));

        Multiplication multiplication = new Multiplication(new SimpleValue(5), new SimpleValue(6), new SimpleValue(8));
        multiplication.setId("3");

        Division division = new Division();
        division.setId("4");
        division.setDividend(new SimpleValue(54));
        division.setDivisor(new SimpleValue(9));

        Expressions expressions =  new Expressions(addition, subtraction, multiplication, division);

        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        List<Result> resultList = expressionCalculator.calculateExpression(expressions);

        assertEquals(9L, (long) resultList.get(0).getResult());
        assertEquals(1L, (long) resultList.get(1).getResult());
        assertEquals(240L, (long) resultList.get(2).getResult());
        assertEquals(6L, (long) resultList.get(3).getResult());

    }

    @Test
    public void testNordeaComplexCase()
    {

        Subtraction subtractionNested = new Subtraction();
        subtractionNested.setMinuend(new SimpleValue(7));
        subtractionNested.setSubtrahend(new SimpleValue(3));

        Addition additionNested1 = new Addition(new SimpleValue(2), new SimpleValue(3), new SimpleValue(4));
        Addition additionNested2 = new Addition(new SimpleValue(3), new SimpleValue(6));

        Multiplication multiplicationNested = new Multiplication(new SimpleValue(3), new SimpleValue(4), new SimpleValue(5), new SimpleValue(10), new SimpleValue(56));

        Addition addition = new Addition(new SimpleValue(2), new SimpleValue(3), subtractionNested);
        addition.setId("10");

        Subtraction subtraction = new Subtraction();
        subtraction.setId("11");
        subtraction.setMinuend(new SimpleValue(3));
        subtraction.setSubtrahend(new SimpleValue(2));

        Multiplication multiplication1 = new Multiplication(new SimpleValue(5), new SimpleValue(6), new SimpleValue(8));
        multiplication1.setId("12");

        Multiplication multiplication2 = new Multiplication(additionNested1, new SimpleValue(6), multiplicationNested);
        multiplication2.setId("13");

        Division division = new Division();
        division.setId("14");
        division.setDividend(new SimpleValue(54));
        division.setDivisor(additionNested2);

        Expressions expressions =  new Expressions(addition, subtraction, multiplication1,multiplication2, division);

        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        List<Result> resultList = expressionCalculator.calculateExpression(expressions);

        assertEquals(9L, (long) resultList.get(0).getResult());
        assertEquals(1L, (long) resultList.get(1).getResult());
        assertEquals(240L, (long) resultList.get(2).getResult());
        assertEquals(1814400L, (long) resultList.get(3).getResult());
        assertEquals(6L, (long) resultList.get(4).getResult());

    }
}
