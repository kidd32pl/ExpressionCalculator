package com.kidd32pl.model;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class SimpleValue implements ICalculable
{
    private Integer value;

    public SimpleValue(Integer value)
    {
        this.value = value;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    @Override public Integer calculate()
    {
        return value;
    }
}
