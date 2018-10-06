package de.freese.benchmark.mapping.mapper.dozer;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
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

        BeanMappingBuilder mappingBuilder = new BeanMappingBuilder()
        {
            /**
             * @see com.github.dozermapper.core.loader.api.BeanMappingBuilder#configure()
             */
            @Override
            protected void configure()
            {
                // @formatter:off
                mapping(Order.class, OrderDTO.class)
                    .fields("customer.name", "customerName")
                    .fields("customer.billingAddress.street", "billingStreetAddress")
                    .fields("customer.billingAddress.city", "billingCity")
                    .fields("customer.shippingAddress.street", "shippingStreetAddress")
                    .fields("customer.shippingAddress.city", "shippingCity")
                    ;
                // @formatter:on
            }
        };

        // @formatter:off
        this.mapper = DozerBeanMapperBuilder.create()
                .withMappingBuilder(mappingBuilder)
                //.withMappingFiles("de/freese/benchmark/mapping/mapper/dozer/dozer.xml")
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
