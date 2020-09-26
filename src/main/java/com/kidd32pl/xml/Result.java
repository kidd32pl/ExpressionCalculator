package com.kidd32pl.xml;

/**
 * Created by mjozefcz on 26/09/2020.
 */
public class Result
{

    public Result(String id, Integer result)
    {
        this.id = id;
        this.result = result;
    }

    private String id;
    private Integer result;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getResult()
    {
        return result;
    }

    public void setResult(Integer result)
    {
        this.result = result;
    }
}
