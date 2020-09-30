package com.kidd32pl;

import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class ExpressionCalculatorTest extends XMLTestCase
{
    private Document getDocument (String fileName)
    {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        File file = null;
        if (url != null)
        {
            file = new File(url.getFile());
        }

        SAXReader reader = new SAXReader();
        Document document = null;
        try
        {
            document = reader.read(file);
        }
        catch (DocumentException e)
        {
            e.printStackTrace();
        }

        return document;
    }

    public void testNordeaSimpleCase() throws SAXException, IOException
    {
        Document document = getDocument("input/simple.xml");

        Document documentResult = new ExpressionCalculator(document).processFile();

        Document expectedResult = getDocument("output/simple_result.xml");

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expectedResult.asXML(), documentResult.asXML());

    }

    public void testNordeaComplexCase() throws SAXException, IOException
    {
        Document document = getDocument("input/complex.xml");

        Document documentResult = new ExpressionCalculator(document).processFile();

        Document expectedResult = getDocument("output/complex_result.xml");

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expectedResult.asXML(), documentResult.asXML());
    }
}
