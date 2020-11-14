package de.freese.benchmark.mapping.mapper;

import de.freese.benchmark.mapping.mapper.mapstruct.MapStructMapper;

/**
 * @author Thomas Freese
 */
public class MapStructMapperTest extends AbstractMapperTest
{
    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new MapStructMapper();
    }
}
