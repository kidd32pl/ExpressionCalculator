package com.kidd32pl.xml;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Subtraction extends Operation
{
    private ICalculable minuend;
    private ICalculable subtrahend;

    public ICalculable getMinuend()
    {
        return minuend;
    }

    public void setMinuend(ICalculable minuend)
    {
        this.minuend = minuend;
    }

    public ICalculable getSubtrahend()
    {
        return subtrahend;
    }

    public void setSubtrahend(ICalculable subtrahend)
    {
        this.subtrahend = subtrahend;
    }

    @Override public Integer calculate()
    {
        return minuend.calculate() - subtrahend.calculate();
    }
}
