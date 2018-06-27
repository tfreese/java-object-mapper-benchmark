package de.freese.benchmark.mapping.mapper.jmapper;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.dto.ProductDTO;
import de.freese.benchmark.mapping.model.entity.Order;

/**
 * @author Thomas Freese
 */
public class JMapperMapper implements OrderMapper
{
    /**
     * 
     */
    private final JMapper<OrderDTO, Order> mapper;

    /**
     * Erstellt ein neues {@link JMapperMapper} Object.
     */
    public JMapperMapper()
    {

        super();

        // @formatter:off
        JMapperAPI api = new JMapperAPI()
                .add(mappedClass(OrderDTO.class)
                .add(attribute("shippingStreetAddress").value("${customer.shippingAddress.street}"))
                .add(attribute("shippingCity").value("${customer.shippingAddress.city}"))
                .add(attribute("billingStreetAddress").value("${customer.billingAddress.street}"))
                .add(attribute("billingCity").value("${customer.billingAddress.city}"))
                .add(attribute("products").value("products"))
                .add(attribute("customerName").value("${customer.name}")))
                .add(mappedClass(ProductDTO.class)
                .add(attribute("name").value("name")));
        // @formatter:on

        this.mapper = new JMapper<>(OrderDTO.class, Order.class, api);
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.OrderMapper#map(de.freese.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        return this.mapper.getDestination(source);
    }
}
