package de.freese.benchmark.mapping.mapper;

import de.freese.benchmark.mapping.mapper.dozer.DozerMapper;

/**
 * @author Thomas Freese
 */
public class DozerMapperTest extends AbstractMapperTest
{
    /**
     * Erstellt ein neues {@link DozerMapperTest} Object.
     */
    public DozerMapperTest()
    {
        super();
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new DozerMapper();
    }
}
