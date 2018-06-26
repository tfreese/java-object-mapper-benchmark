package com.javaetmoi.benchmark.mapping.mapper.mapstruct;

import org.mapstruct.factory.Mappers;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

/**
 * @author Thomas Freese
 */
public class MapStructMapper implements OrderMapper
{
    /**
     *
     */
    private final MapStructOrderMapper mapper;

    /**
     * Erstellt ein neues {@link MapStructMapper} Object.
     */
    public MapStructMapper()
    {
        super();

        this.mapper = Mappers.getMapper(MapStructOrderMapper.class);
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
