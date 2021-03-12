package de.freese.benchmark.mapping.model.entity;

/**
 * @author Thomas Freese
 */
public class Address
{
    /**
     *
     */
    private String city;

    /**
     *
     */
    private String street;

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
