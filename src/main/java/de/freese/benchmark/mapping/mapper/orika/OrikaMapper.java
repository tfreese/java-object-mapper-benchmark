package de.freese.benchmark.mapping.mapper.orika;

import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Using custom BoundMapperFacade with no object graph cycles.
 *
 * @see <a href="http://orika-mapper.github.io/orika-docs/performance-tuning.html">http://orika-mapper.github.io/orika-docs/performance-tuning.html</a>
 */
public class OrikaMapper implements OrderMapper
{
    /**
     *
     */
    private final BoundMapperFacade<Order, OrderDTO> orderMapper;

    /**
     * Erstellt ein neues {@link OrikaMapper} Object.
     */
    public OrikaMapper()
    {
        super();

        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        // @formatter:off
        factory.registerClassMap(factory.classMap(Order.class, OrderDTO.class)
                .field("customer.name", "customerName")
                .field("customer.billingAddress.street", "billingStreetAddress")
                .field("customer.billingAddress.city", "billingCity")
                .field("customer.shippingAddress.street", "shippingStreetAddress")
                .field("customer.shippingAddress.city", "shippingCity")
                .field("products", "products")
                .toClassMap());
        // @formatter:on

        this.orderMapper = factory.getMapperFacade(Order.class, OrderDTO.class, false);
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.OrderMapper#map(de.freese.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        return this.orderMapper.map(source);
    }
}
