package com.kidd32pl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Multiplication extends Operation
{
    private List<ICalculable> factors = new ArrayList<>();

    public Multiplication(ICalculable... multiplicationValues)
    {
        factors = Arrays.asList(multiplicationValues);
    }

    @SuppressWarnings("unused")
    public Multiplication() {}

    @SuppressWarnings("unused")
    public void addFactor(ICalculable factor)
    {
        factors.add(factor);
    }

    @Override public Integer calculate()
    {
        return factors.stream().map(ICalculable::calculate).reduce(1, (a, b) -> a * b);
    }
}
