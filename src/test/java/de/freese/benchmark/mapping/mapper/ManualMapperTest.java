package de.freese.benchmark.mapping.mapper;

import de.freese.benchmark.mapping.mapper.manual.ManualMapper;

/**
 * @author Thomas Freese
 */
public class ManualMapperTest extends AbstractMapperTest
{
    /**
     * Erstellt ein neues {@link ManualMapperTest} Object.
     */
    public ManualMapperTest()
    {
        super();
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new ManualMapper();
    }
}
