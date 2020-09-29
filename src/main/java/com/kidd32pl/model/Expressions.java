package com.kidd32pl.model;

import java.util.Arrays;
import java.util.List;

public class Expressions
{
    private List<Operation> operations;

    public Expressions() {}

    public Expressions (Operation... operations)
    {
        this.operations = Arrays.asList(operations);
    }

    public List<Operation> getOperations()
    {
        return operations;
    }

    public void setOperations(List<Operation> operations)
    {
        this.operations = operations;
    }



}
