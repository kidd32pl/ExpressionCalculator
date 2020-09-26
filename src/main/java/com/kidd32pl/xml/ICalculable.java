package com.kidd32pl.xml;

import com.kidd32pl.adapters.OperationDataAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by mjozefcz on 25/09/2020.
 */
@XmlJavaTypeAdapter( OperationDataAdapter.class )
public interface ICalculable
{
    public Integer calculate();
}
