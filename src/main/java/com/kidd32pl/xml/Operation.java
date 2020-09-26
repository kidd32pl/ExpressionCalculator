package com.kidd32pl.xml;

import javax.xml.bind.annotation.XmlAttribute;


public abstract class Operation implements ICalculable
{

    private String id;
    private Boolean complex;

    public String getId()
    {
        return id;
    }

    @XmlAttribute
    public void setId(String id)
    {
        this.id = id;
    }

    public Boolean isComplex()
    {
        return complex;
    }

    @XmlAttribute
    public void setComplex(Boolean complex)
    {
        this.complex = complex;
    }
}
