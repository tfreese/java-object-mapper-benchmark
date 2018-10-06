package de.freese.benchmark.mapping.mapper;

import org.junit.Ignore;
import de.freese.benchmark.mapping.mapper.mapstruct.MapStructMapper;

/**
 * @author Thomas Freese
 */
@Ignore
public class MapStructMapperTest extends AbstractMapperTest
{
    /**
     * Erstellt ein neues {@link MapStructMapperTest} Object.
     */
    public MapStructMapperTest()
    {
        super();
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new MapStructMapper();
    }
}
