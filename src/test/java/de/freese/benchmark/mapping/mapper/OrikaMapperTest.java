package de.freese.benchmark.mapping.mapper;

import de.freese.benchmark.mapping.mapper.orika.OrikaMapper;

/**
 * @author Thomas Freese
 */
public class OrikaMapperTest extends AbstractMapperTest
{
    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new OrikaMapper();
    }
}
