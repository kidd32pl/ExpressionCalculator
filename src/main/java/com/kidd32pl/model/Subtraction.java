package com.kidd32pl.model;

public class Subtraction extends Operation
{
    private ICalculable minuend;
    private ICalculable subtrahend;

    public void addMinuend(ICalculable minuend)
    {
        this.minuend = minuend;
    }

    public void addSubtrahend(ICalculable subtrahend)
    {
        this.subtrahend = subtrahend;
    }

    @Override public Integer calculate()
    {
        return minuend.calculate() - subtrahend.calculate();
    }
}
