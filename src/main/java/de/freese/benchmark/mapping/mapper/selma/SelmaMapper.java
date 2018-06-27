package de.freese.benchmark.mapping.mapper.selma;

import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;
import fr.xebia.extras.selma.Selma;

/**
 * @author Thomas Freese
 */
public class SelmaMapper implements OrderMapper
{
    /**
     *
     */
    private final SelmaOrderMapper mapper;

    /**
     * Erstellt ein neues {@link SelmaMapper} Object.
     */
    public SelmaMapper()
    {
        super();

        this.mapper = Selma.builder(SelmaOrderMapper.class).build();
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.OrderMapper#map(de.freese.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        return this.mapper.map(source);
    }
}
