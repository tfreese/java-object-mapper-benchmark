package de.freese.benchmark.mapping.mapper;

import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.mapper.selma.SelmaMapper;

/**
 * @author Thomas Freese
 */
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
