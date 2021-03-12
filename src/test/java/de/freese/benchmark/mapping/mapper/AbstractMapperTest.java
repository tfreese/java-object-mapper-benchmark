package de.freese.benchmark.mapping.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import de.freese.benchmark.mapping.model.OrderFactory;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;

/**
 * @author Thomas Freese
 */
abstract class AbstractMapperTest
{
    /**
     * @return {@link OrderMapper}
     */
    protected abstract OrderMapper getOrderMapper();

    /**
     *
     */
    @Test
    void map()
    {
        Order order = OrderFactory.buildOrder();
        OrderDTO orderDTO = getOrderMapper().map(order);

        assertEquals("Joe Smith", orderDTO.getCustomerName());
        assertEquals("1234 Market Street", orderDTO.getBillingStreetAddress());
        assertEquals("San Fran", orderDTO.getBillingCity());
        assertEquals("1234 West Townsend", orderDTO.getShippingStreetAddress());
        assertEquals("Boston", orderDTO.getShippingCity());
        assertEquals("socks", orderDTO.getProducts().get(0).getName());
        assertEquals("shoes", orderDTO.getProducts().get(1).getName());
    }
}
