package com.kidd32pl.xml;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
public class Addition extends Operation
{
    public Addition (ICalculable... calculableItems)
    {
        items = Arrays.asList(calculableItems);
    }

    private List<ICalculable> items;

    public List<ICalculable> getItems()
    {
        return items;
    }

    @XmlAnyElement
    public void setItems(List<ICalculable> items)
    {
        this.items = items;
    }


    @Override public Integer calculate()
    {

         return items.stream().mapToInt(ICalculable::calculate).sum();
    }
}
