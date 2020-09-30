package com.kidd32pl.model;

public abstract class Operation implements ICalculable
{
    private String id;

    @SuppressWarnings("unused")
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
