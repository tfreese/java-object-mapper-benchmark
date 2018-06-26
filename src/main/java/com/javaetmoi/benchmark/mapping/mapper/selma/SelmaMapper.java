package com.javaetmoi.benchmark.mapping.mapper.selma;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
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
     * @see com.javaetmoi.benchmark.mapping.mapper.OrderMapper#map(com.javaetmoi.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        return this.mapper.map(source);
    }
}
