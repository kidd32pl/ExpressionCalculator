package com.kidd32pl;

import com.kidd32pl.xml.Expressions;
import com.kidd32pl.xml.Result;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mjozefcz on 25/09/2020.
 */
public class ExpressionCalculatorMain
{
    final static String xml1 = "<expressions>"
                              + "</expressions>";

    final static String xml = "<expressions>"
                       + "  <addition complex=\"true\" id=\"1\">"
                       + "    <item>1</item>"
                       + "    <item>2</item>"
                       + "    <item class=\"addition\"/>"
                       + "  </addition>"
                       + "</expressions>";
    public static void main (String[] args) throws JAXBException
    {
        if (args == null || args.length != 2 )
        {
            printHelp();
        }

        String inputFolder = args[0];
        String outputFolder = args[1];

        JAXBContext jaxbContext = JAXBContext.newInstance(Expressions.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();


        try (Stream<Path> paths = Files.walk(Paths.get(inputFolder))) {

            paths.filter(s -> s.getFileName().toString().endsWith(".xml"))
                    .forEach(file -> {

                        try
                        {
                            System.out.println("Calculating file: " +  file.toString());
                            Expressions expressions = (Expressions) jaxbUnmarshaller.unmarshal(file.toFile());

                            List<Result> resultList  = expressionCalculator.calculateExpression(expressions);

                        }
                        catch (JAXBException e)
                        {
                            e.printStackTrace();
                        }

                    });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }







    }

    private static void printHelp()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------\n");
        sb.append("----- Expression Calculator\n");
        sb.append("-------------------------------\n");
        sb.append(System.lineSeparator());
        sb.append(" Usage: \n");
        sb.append(" java -jar ExpressionCalculator.jar <input_dir_path> <output_dir_path");

        System.out.println(sb.toString());
        System.exit(0);
    }
}
