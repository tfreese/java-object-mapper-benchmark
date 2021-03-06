package de.freese.benchmark.mapping.mapper.manual;

import java.util.ArrayList;
import java.util.List;
import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.dto.ProductDTO;
import de.freese.benchmark.mapping.model.entity.Customer;
import de.freese.benchmark.mapping.model.entity.Order;
import de.freese.benchmark.mapping.model.entity.Product;

/**
 * @author Thomas Freese
 */
public final class ManualMapper implements OrderMapper
{
    /**
     * Erstellt ein neues {@link ManualMapper} Object.
     */
    public ManualMapper()
    {
        super();
    }

    /**
     * @see de.freese.benchmark.mapping.mapper.OrderMapper#map(de.freese.benchmark.mapping.model.entity.Order)
     */
    @Override
    public OrderDTO map(final Order source)
    {
        OrderDTO target = new OrderDTO();
        Customer customer = source.getCustomer();

        if (customer != null)
        {
            target.setCustomerName(customer.getName());

            if (customer.getBillingAddress() != null)
            {
                target.setBillingCity(customer.getBillingAddress().getCity());
                target.setBillingStreetAddress(customer.getBillingAddress().getStreet());
            }

            if (customer.getShippingAddress() != null)
            {
                target.setShippingCity(customer.getShippingAddress().getCity());
                target.setShippingStreetAddress(customer.getShippingAddress().getStreet());
            }
        }

        if (source.getProducts() != null)
        {
            List<ProductDTO> targetProducts = new ArrayList<>(source.getProducts().size());

            for (Product product : source.getProducts())
            {
                targetProducts.add(new ProductDTO(product.getName()));
            }

            target.setProducts(targetProducts);
        }

        return target;
    }
}
