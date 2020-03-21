package de.freese.benchmark.mapping.mapper;

import de.freese.benchmark.mapping.mapper.modelmapper.ModelMapper;

/**
 * @author Thomas Freese
 */
public class ModelMapperTest extends AbstractMapperTest
{
    /**
     * Erstellt ein neues {@link ModelMapperTest} Object.
     */
    public ModelMapperTest()
    {
        super();
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new ModelMapper();
    }
}
