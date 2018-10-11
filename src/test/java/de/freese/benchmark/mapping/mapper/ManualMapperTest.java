package de.freese.benchmark.mapping.mapper;

import org.junit.Ignore;
import de.freese.benchmark.mapping.mapper.manual.ManualMapper;

/**
 * @author Thomas Freese
 */
@Ignore
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
