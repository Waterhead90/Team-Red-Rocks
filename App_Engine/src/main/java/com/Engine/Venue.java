package com.Engine;

import java.io.Serializable;

/**
 *
 * @author donovan.beckmann
 */
public class Venue implements Serializable{
    private String name;
    private String memberName;

    public Venue(String name)
    {
        this.name = name;
    }

    public String getName() { return name;}
}
