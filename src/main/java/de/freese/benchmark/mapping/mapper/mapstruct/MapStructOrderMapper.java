package de.freese.benchmark.mapping.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.dto.ProductDTO;
import de.freese.benchmark.mapping.model.entity.Order;
import de.freese.benchmark.mapping.model.entity.Product;

/**
 * @author Thomas Freese
 */
@Mapper
public interface MapStructOrderMapper extends OrderMapper
{
    /**
     * @see de.freese.benchmark.mapping.mapper.OrderMapper#map(de.freese.benchmark.mapping.model.entity.Order)
     */
    @Override
    @Mappings(
    {
            @Mapping(source = "customer.name", target = "customerName"),
            @Mapping(source = "customer.billingAddress.street", target = "billingStreetAddress"),
            @Mapping(source = "customer.billingAddress.city", target = "billingCity"),
            @Mapping(source = "customer.shippingAddress.street", target = "shippingStreetAddress"),
            @Mapping(source = "customer.shippingAddress.city", target = "shippingCity"),
    })
    public OrderDTO map(Order source);

    /**
     * @param product {@link Product}
     * @return {@link ProductDTO}
     */
    @Mapping(source = "name", target = "name")
    public ProductDTO productToProductDTO(Product product);
}