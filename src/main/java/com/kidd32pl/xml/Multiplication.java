package com.kidd32pl.xml;

import java.util.Arrays;
import java.util.List;

public class Multiplication extends Operation
{
    public Multiplication(ICalculable... multiplicationValues)
    {
        factors = Arrays.asList(multiplicationValues);
    }

    private List<ICalculable> factors;

    public List<ICalculable> getFactors()
    {
        return factors;
    }

    public void setFactors(List<ICalculable> factors)
    {
        this.factors = factors;
    }

    @Override public Integer calculate()
    {

        return factors.stream().map(ICalculable::calculate).reduce(1, (a, b) -> a * b);
    }
}
