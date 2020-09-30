package com.kidd32pl;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ExpressionCalculatorMain
{
    private static final Logger logger = LogManager.getLogger(ExpressionCalculatorMain.class);

    public static void main(String[] args)
    {
        BasicConfigurator.configure();

        if (args != null && args.length == 2)
        {
            String inputFolder = args[0];
            String outputFolder = args[1];

            try (Stream<Path> paths = Files.walk(Paths.get(inputFolder)))
            {

                paths.filter(s -> s.getFileName().toString().endsWith(".xml")).forEach(file -> {
                    logger.info("Calculating file: " + file.toString());

                    Document document = null;
                    SAXReader reader = new SAXReader();
                    try
                    {
                        document = reader.read(file.toFile());
                    }
                    catch (DocumentException e)
                    {
                        logger.error("Couldn't parse the file", e);
                    }

                    ExpressionCalculator expressionCalculator = new ExpressionCalculator(document);
                    Document result = expressionCalculator.processFile();

                    String fileNameWithOutExt = FilenameUtils.removeExtension(file.toFile().getName());
                    String outputFile = outputFolder + File.separator + fileNameWithOutExt + "_result.xml";

                    try (FileWriter fileWriter = new FileWriter(outputFile))
                    {
                        OutputFormat format = OutputFormat.createPrettyPrint();
                        format.setSuppressDeclaration(true);
                        XMLWriter writer = new XMLWriter(fileWriter, format);
                        writer.write(result);
                        writer.close();
                    }
                    catch (IOException e)
                    {
                        logger.error("Exception on saving results ", e);
                    }
                });
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            printHelp();
        }

    }

    private static void printHelp()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("-------------------------------\n");
        sb.append("----- Expression Calculator\n");
        sb.append("-------------------------------\n");
        sb.append(System.lineSeparator());
        sb.append(" Usage: \n");
        sb.append(" java -jar ExpressionCalculator.jar <input_dir_path> <output_dir_path");

        logger.info(sb.toString());
        System.exit(0);
    }
}
