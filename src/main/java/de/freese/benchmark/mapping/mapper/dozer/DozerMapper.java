package de.freese.benchmark.mapping.mapper.dozer;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;

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
                .withMappingFiles("de/freese/benchmark/mapping/mapper/dozer/dozer.xml")
                .build();
        // @formatter:on
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.OrderMapper#map(de.freese.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        return this.mapper.map(source, OrderDTO.class);
    }
}
