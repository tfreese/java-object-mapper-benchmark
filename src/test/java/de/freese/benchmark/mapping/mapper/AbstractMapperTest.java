package de.freese.benchmark.mapping.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import de.freese.benchmark.mapping.model.OrderFactory;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;

/**
 * @author Thomas Freese
 */
public abstract class AbstractMapperTest
{
    /**
     * Erstellt ein neues {@link AbstractMapperTest} Object.
     */
    public AbstractMapperTest()
    {
        super();
    }

    /**
     * @return {@link OrderMapper}
     */
    protected abstract OrderMapper getOrderMapper();

    /**
     *
     */
    @Test
    public void map()
    {
        Order order = OrderFactory.buildOrder();
        OrderDTO orderDTO = getOrderMapper().map(order);

        assertEquals(orderDTO.getCustomerName(), "Joe Smith");
        assertEquals(orderDTO.getBillingStreetAddress(), "1234 Market Street");
        assertEquals(orderDTO.getBillingCity(), "San Fran");
        assertEquals(orderDTO.getShippingStreetAddress(), "1234 West Townsend");
        assertEquals(orderDTO.getShippingCity(), "Boston");
        assertEquals(orderDTO.getProducts().get(0).getName(), "socks");
        assertEquals(orderDTO.getProducts().get(1).getName(), "shoes");
    }
}
