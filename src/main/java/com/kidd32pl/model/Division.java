package com.kidd32pl.model;

public class Division extends Operation
{
    private ICalculable dividend;
    private ICalculable divisor;

    public void addDividend(ICalculable dividend)
    {
        this.dividend = dividend;
    }

    public void addDivisor(ICalculable divisor)
    {
        this.divisor = divisor;
    }

    @Override public Integer calculate() throws ArithmeticException
    {
        Integer dividendValue = dividend.calculate();
        Integer divisorValue = divisor.calculate();

        if (divisorValue == 0)
        {
            throw new ArithmeticException("Dividing by 0 detected.");
        }

        return dividendValue/divisorValue;
    }
}
