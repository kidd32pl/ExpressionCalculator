package com.kidd32pl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Addition extends Operation
{

    private List<ICalculable> items = new ArrayList<>();

    public Addition (){}

    public Addition (ICalculable... calculableItems)
    {
        items = Arrays.asList(calculableItems);
    }

    @SuppressWarnings("unused")
    public void addItem(ICalculable item)
    {
        items.add(item);
    }

    @Override public Integer calculate()
    {
         return items.stream().mapToInt(ICalculable::calculate).sum();
    }
}
