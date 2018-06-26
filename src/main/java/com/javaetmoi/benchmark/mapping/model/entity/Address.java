package com.javaetmoi.benchmark.mapping.model.entity;

/**
 * @author Thomas Freese
 */
public class Address
{
    /**
     *
     */
    private String street = null;

    /**
     *
     */
    private String city = null;

    /**
     * Erstellt ein neues {@link Address} Object.
     */
    public Address()
    {
        super();
    }

    /**
     * @return String
     */
    public String getCity()
    {
        return this.city;
    }

    /**
     * @return String
     */
    public String getStreet()
    {
        return this.street;
    }

    /**
     * @param city String
     */
    public void setCity(final String city)
    {
        this.city = city;
    }

    /**
     * @param street String
     */
    public void setStreet(final String street)
    {
        this.street = street;
    }
}