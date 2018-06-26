package com.javaetmoi.benchmark.mapping.model.entity;

/**
 * @author Thomas Freese
 */
public class Product
{
    /**
     *
     */
    private String name = null;

    /**
     * Erstellt ein neues {@link Product} Object.
     *
     * @param name String
     */
    public Product(final String name)
    {
        this.name = name;
    }

    /**
     * @return String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name String
     */
    public void setName(final String name)
    {
        this.name = name;
    }
}