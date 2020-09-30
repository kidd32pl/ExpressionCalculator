package com.kidd32pl;

import com.kidd32pl.model.ICalculable;
import com.kidd32pl.model.Result;
import com.kidd32pl.model.SimpleValue;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator
{
    public static final String MODEL_PACKAGE = "com.kidd32pl.model.";

    final private Document document;

    private static final Logger logger = LogManager.getLogger(ExpressionCalculator.class);

    public ExpressionCalculator(Document document) {
        this.document = document;
    }

    /** Processing expressions in xml document
     *
     * @return
     */
    public Document processFile()
    {
        List<Result> results = new ArrayList<>();

        Element rootElement = document.getRootElement();
        for (int i = 0, size = rootElement.nodeCount(); i < size; i++)
        {
            if (rootElement.node(i) instanceof Element)
            {
                Element childElement = (Element)rootElement.node(i);

                Attribute id = childElement.attribute("id");

                if (id != null)
                {
                    Result result = new Result();
                    result.setId(id.getValue());

                    ICalculable expressionResult = null;
                    try
                    {
                        expressionResult = processOperation(childElement);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    if (expressionResult!= null)
                    {
                        result.setResult(expressionResult.calculate());
                    }
                    results.add(result);

                    logger.info("Id: " + result.getId() + " Result: " + result.getResult());
                }

            }
        }

        return processResult(results);
    }

    /**
     * Process single operation and calculate result
     *
     * @param element
     * @return
     * @throws Exception
     */
    private ICalculable processOperation(Element element)
            throws Exception
    {
        final String elementName = element.getName();
        final String className = MODEL_PACKAGE + elementName.substring(0, 1).toUpperCase() + elementName.substring(1);
        final Class<?> operationClass =  Class.forName(className);
        final ICalculable operation = (ICalculable)operationClass.newInstance();

        for (int i = 0, size = element.nodeCount(); i < size; i++)
        {
            if (element.node(i) instanceof Element)
            {
                final Element childElement = (Element)element.node(i);
                final String childElementName = childElement.getQualifiedName();
                final String operationMethodName = "add" + childElementName.substring(0, 1).toUpperCase() + childElementName.substring(1);

                ICalculable operationAttribute = null;


                if (NumberUtils.isCreatable(childElement.getStringValue()))
                {
                    Integer value = Integer.parseInt(childElement.getStringValue());
                    operationAttribute = new SimpleValue(value);
                } else
                {
                    for (int j = 0, sizej = childElement.nodeCount(); j < sizej; j++)
                    {
                        if (childElement.node(j) instanceof Element )
                        {
                            operationAttribute = processOperation((Element)childElement.node(j));
                        }
                    }

                }

                final Method method = operationClass.getMethod(operationMethodName, ICalculable.class);
                method.invoke(operation, operationAttribute);
            }
        }

        return operation;
    }

    /**
     * Preparing XML document with the results
     *
     * @param results
     * @return
     */
    private Document processResult(List<Result> results)
    {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("expressions");

        for (Result result:results)
        {
            root.addElement("result")
                    .addAttribute("id", result.getId())
                    .addText(result.getResult().toString());
        }

        return document;
    }

}
