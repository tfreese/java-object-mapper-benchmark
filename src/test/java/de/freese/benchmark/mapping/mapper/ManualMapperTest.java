package de.freese.benchmark.mapping.mapper;

import de.freese.benchmark.mapping.mapper.manual.ManualMapper;

/**
 * @author Thomas Freese
 */
public class ManualMapperTest extends AbstractMapperTest
{
    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new ManualMapper();
    }
}
