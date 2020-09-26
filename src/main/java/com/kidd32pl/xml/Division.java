package com.kidd32pl.xml;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class Division extends Operation
{
    private ICalculable dividend;
    private ICalculable divisor;

    public ICalculable getDividend()
    {
        return dividend;
    }

    public void setDividend(ICalculable dividend)
    {
        this.dividend = dividend;
    }

    public ICalculable getDivisor()
    {
        return divisor;
    }

    public void setDivisor(ICalculable divisor)
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
