package com.kidd32pl.model;

public abstract class Operation implements ICalculable
{
    private String id;

    private Boolean complex;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Boolean isComplex()
    {
        return complex;
    }

    public void setComplex(Boolean complex)
    {
        this.complex = complex;
    }
}
