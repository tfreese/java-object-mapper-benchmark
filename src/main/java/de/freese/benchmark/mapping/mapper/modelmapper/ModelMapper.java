package de.freese.benchmark.mapping.mapper.modelmapper;

import org.modelmapper.PropertyMap;
import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;

/**
 * @author Thomas Freese
 */
public class ModelMapper implements OrderMapper
{
    /**
     *
     */
    private final org.modelmapper.ModelMapper modelMapper;

    /**
     * Erstellt ein neues {@link ModelMapper} Object.
     */
    public ModelMapper()
    {
        super();

        this.modelMapper = new org.modelmapper.ModelMapper();
        this.modelMapper.addMappings(new PropertyMap<Order, OrderDTO>()
        {
            /**
             * @see org.modelmapper.PropertyMap#configure()
             */
            @Override
            protected void configure()
            {
                map().setBillingStreetAddress(this.source.getCustomer().getBillingAddress().getStreet());
                map().setBillingCity(this.source.getCustomer().getBillingAddress().getCity());
                map().setShippingStreetAddress(this.source.getCustomer().getShippingAddress().getStreet());
                map().setShippingCity(this.source.getCustomer().getShippingAddress().getCity());
            }
        });
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.OrderMapper#map(de.freese.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        return this.modelMapper.map(source, OrderDTO.class);
    }
}
