package com.kidd32pl.xml;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
public class Expressions
{
    private List<ICalculable> operations;

    public Expressions()
    {

    }

    public Expressions (ICalculable... operations)
    {
        this.operations = Arrays.asList(operations);
    }

    public List<ICalculable> getOperations()
    {
        return operations;
    }

    public void setOperations(List<ICalculable> operations)
    {
        this.operations = operations;
    }



}
