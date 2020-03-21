package de.freese.benchmark.mapping.mapper;

import de.freese.benchmark.mapping.mapper.jmapper.JMapperMapper;

/**
 * @author Thomas Freese
 */
public class JMapperMapperTest extends AbstractMapperTest
{
    /**
     * Erstellt ein neues {@link JMapperMapperTest} Object.
     */
    public JMapperMapperTest()
    {
        super();
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new JMapperMapper();
    }
}