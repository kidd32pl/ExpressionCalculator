package com.kidd32pl;

import com.kidd32pl.model.Addition;
import com.kidd32pl.model.Division;
import com.kidd32pl.model.Expressions;
import com.kidd32pl.model.Multiplication;
import com.kidd32pl.model.SimpleValue;
import com.kidd32pl.model.Subtraction;
import org.junit.Test;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class ExpressionCalculatorTest
{

    public void testNordeaSimpleCase()
    {
        Addition addition = new Addition(new SimpleValue(2), new SimpleValue(3), new SimpleValue(4));
        addition.setId("1");

        Subtraction subtraction = new Subtraction();
        subtraction.setId("2");
        subtraction.addMinuend(new SimpleValue(3));
        subtraction.addSubtrahend(new SimpleValue(2));

        Multiplication multiplication = new Multiplication(new SimpleValue(5), new SimpleValue(6), new SimpleValue(8));
        multiplication.setId("3");

        Division division = new Division();
        division.setId("4");
        division.addDividend(new SimpleValue(54));
        division.addDivisor(new SimpleValue(9));

        Expressions expressions =  new Expressions(addition, subtraction, multiplication, division);

        //ExpressionCalculator expressionCalculator = new ExpressionCalculator(new File(""));
        //List<Result> resultList = expressionCalculator.calculateExpression(expressions);

//        assertEquals(9L, (long) resultList.get(0).getResult());
//        assertEquals(1L, (long) resultList.get(1).getResult());
//        assertEquals(240L, (long) resultList.get(2).getResult());
//        assertEquals(6L, (long) resultList.get(3).getResult());

    }

    @Test
    public void testNordeaComplexCase()
    {

        Subtraction subtractionNested = new Subtraction();
        subtractionNested.addMinuend(new SimpleValue(7));
        subtractionNested.addSubtrahend(new SimpleValue(3));

        Addition additionNested1 = new Addition(new SimpleValue(2), new SimpleValue(3), new SimpleValue(4));
        Addition additionNested2 = new Addition(new SimpleValue(3), new SimpleValue(6));

        Multiplication multiplicationNested = new Multiplication(new SimpleValue(3), new SimpleValue(4), new SimpleValue(5), new SimpleValue(10), new SimpleValue(56));

        Addition addition = new Addition(new SimpleValue(2), new SimpleValue(3), subtractionNested);
        addition.setId("10");

        Subtraction subtraction = new Subtraction();
        subtraction.setId("11");
        subtraction.addMinuend(new SimpleValue(3));
        subtraction.addSubtrahend(new SimpleValue(2));

        Multiplication multiplication1 = new Multiplication(new SimpleValue(5), new SimpleValue(6), new SimpleValue(8));
        multiplication1.setId("12");

        Multiplication multiplication2 = new Multiplication(additionNested1, new SimpleValue(6), multiplicationNested);
        multiplication2.setId("13");

        Division division = new Division();
        division.setId("14");
        division.addDividend(new SimpleValue(54));
        division.addDivisor(additionNested2);

        Expressions expressions =  new Expressions(addition, subtraction, multiplication1,multiplication2, division);

        //ExpressionCalculator expressionCalculator = new ExpressionCalculator(new File(""));
//        List<Result> resultList = expressionCalculator.calculateExpression(expressions);
//
//        assertEquals(9L, (long) resultList.get(0).getResult());
//        assertEquals(1L, (long) resultList.get(1).getResult());
//        assertEquals(240L, (long) resultList.get(2).getResult());
//        assertEquals(1814400L, (long) resultList.get(3).getResult());
//        assertEquals(6L, (long) resultList.get(4).getResult());

    }
}
