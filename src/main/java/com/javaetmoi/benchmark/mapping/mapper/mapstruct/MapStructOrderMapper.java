package com.javaetmoi.benchmark.mapping.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.dto.ProductDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.Product;

/**
 * @author Thomas Freese
 */
@Mapper
public interface MapStructOrderMapper extends OrderMapper
{
    /**
     * @see com.javaetmoi.benchmark.mapping.mapper.OrderMapper#map(com.javaetmoi.benchmark.mapping.model.entity.Order)
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