package de.freese.benchmark.mapping.mapper.mapstruct;

import org.mapstruct.factory.Mappers;
import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;

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
     * @see de.freese.benchmark.mapping.mapper.OrderMapper#map(de.freese.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        return this.mapper.map(source);
    }
}
