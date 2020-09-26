package com.kidd32pl;

import com.kidd32pl.xml.Expressions;
import com.kidd32pl.xml.ICalculable;
import com.kidd32pl.xml.Operation;
import com.kidd32pl.xml.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class ExpressionCalculator
{


    public ExpressionCalculator(){
    }

    public List<Result> calculateExpression(Expressions expressions)
    {
        List<ICalculable> operations = expressions.getOperations();
        List<Result> resultList = new ArrayList<>();
        for (ICalculable operation : operations)
        {
            Integer operationResult = operation.calculate();
            Result result = new Result(((Operation)operation).getId(), operationResult);
            resultList.add(result);
        }
        return resultList;
    }

}
