package de.freese.benchmark.mapping.mapper.selma;

import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.dto.ProductDTO;
import de.freese.benchmark.mapping.model.entity.Order;
import de.freese.benchmark.mapping.model.entity.Product;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;

/**
 * @author Thomas Freese
 */
@Mapper(withCustomFields =
{
        @Field(
        {
                "customer.name", "customerName"
        }), @Field(
        {
                "customer.billingAddress.street", "billingStreetAddress"
        }), @Field(
        {
                "customer.billingAddress.city", "billingCity"
        }), @Field(
        {
                "customer.shippingAddress.street", "shippingStreetAddress"
        }), @Field(
        {
                "customer.shippingAddress.city", "shippingCity"
        })
})
public interface SelmaOrderMapper
{
    /**
     * @param source {@link Order}
     * @return {@link OrderDTO}
     */
    public OrderDTO map(Order source);

    /**
     * @param product {@link Product}
     * @return {@link ProductDTO}
     */
    public ProductDTO map(Product product);
}
