package com.javaetmoi.benchmark.mapping.mapper.dozer;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

/**
 * @author Thomas Freese
 */
public class DozerMapper implements OrderMapper
{
    /**
     *
     */
    private final Mapper mapper;

    /**
     * Erstellt ein neues {@link DozerMapper} Object.
     */
    public DozerMapper()
    {
        super();

        // @formatter:off
        this.mapper = DozerBeanMapperBuilder.create()
                .withMappingFiles("com/javaetmoi/benchmark/mapping/mapper/dozer/dozer.xml")
                .build();
        // @formatter:on
    }

    /**
     * @see com.javaetmoi.benchmark.mapping.mapper.OrderMapper#map(com.javaetmoi.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        return this.mapper.map(source, OrderDTO.class);
    }
}
