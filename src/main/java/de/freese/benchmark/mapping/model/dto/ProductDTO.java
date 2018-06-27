package de.freese.benchmark.mapping.model.dto;

/**
 * @author Thomas Freese
 */
public class ProductDTO
{
    /**
     *
     */
    private String name = null;

    /**
     * Erstellt ein neues {@link ProductDTO} Object.
     */
    public ProductDTO()
    {
        super();
    }

    /**
     * Erstellt ein neues {@link ProductDTO} Object.
     *
     * @param name String
     */
    public ProductDTO(final String name)
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