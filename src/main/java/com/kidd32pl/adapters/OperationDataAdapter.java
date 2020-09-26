package com.kidd32pl.adapters;

import com.kidd32pl.xml.Addition;
import com.kidd32pl.xml.ICalculable;
import com.kidd32pl.xml.Operation;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjozefcz on 25/09/2020.
 */
public class OperationDataAdapter extends XmlAdapter<String, ArrayList<Operation>>
{

    @Override public ArrayList<Operation> unmarshal(String v) throws Exception
    {
//        ElementNSImpl element = (ElementNSImpl) v;
//
//        if (element.getLocalName().equals("addition"))
//        {
//            return null;
//        }
        return null;
    }

    @Override public String marshal(ArrayList<Operation> v) throws Exception
    {
        return null;
    }
}
