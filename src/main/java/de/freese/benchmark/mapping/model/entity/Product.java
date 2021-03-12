package de.freese.benchmark.mapping.model.entity;

/**
 * @author Thomas Freese
 */
public class Product
{
    /**
     *
     */
    private String name;

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
