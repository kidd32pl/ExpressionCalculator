package com.kidd32pl.model;

public class SimpleValue implements ICalculable
{
    final private Integer value;

    public SimpleValue(Integer value)
    {
        this.value = value;
    }

    @Override public Integer calculate()
    {
        return value;
    }
}
