package de.freese.benchmark.mapping.mapper;

import org.junit.Ignore;
import de.freese.benchmark.mapping.mapper.selma.SelmaMapper;

/**
 * @author Thomas Freese
 */
@Ignore
public class SelmaMapperTest extends AbstractMapperTest
{
    /**
     * Erstellt ein neues {@link SelmaMapperTest} Object.
     */
    public SelmaMapperTest()
    {
        super();
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.AbstractMapperTest#getOrderMapper()
     */
    @Override
    protected OrderMapper getOrderMapper()
    {
        return new SelmaMapper();
    }
}
