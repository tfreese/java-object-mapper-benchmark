package de.freese.benchmark.mapping.model;

import java.util.ArrayList;
import java.util.List;
import de.freese.benchmark.mapping.model.entity.Address;
import de.freese.benchmark.mapping.model.entity.Customer;
import de.freese.benchmark.mapping.model.entity.Order;
import de.freese.benchmark.mapping.model.entity.Product;

/**
 * @author Thomas Freese
 */
public class OrderFactory
{

    /**
     * @return {@link Order}
     */
    public static Order buildOrder()
    {
        Order order = new Order();
        Customer customer = new Customer();

        order.setCustomer(customer);
        customer.setName("Joe Smith");

        Address billingAddress = new Address();
        customer.setBillingAddress(billingAddress);
        billingAddress.setStreet("1234 Market Street");
        billingAddress.setCity("San Fran");

        Address shippingAddress = new Address();
        customer.setShippingAddress(shippingAddress);
        shippingAddress.setStreet("1234 West Townsend");
        shippingAddress.setCity("Boston");

        List<Product> products = new ArrayList<>(2);
        order.setProducts(products);
        products.add(new Product("socks"));
        products.add(new Product("shoes"));

        return order;
    }
}
