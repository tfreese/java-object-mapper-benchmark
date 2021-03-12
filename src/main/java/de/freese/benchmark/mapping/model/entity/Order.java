package de.freese.benchmark.mapping.model.entity;

import java.util.List;

/**
 * @author Thomas Freese
 */
public class Order
{
    /**
     *
     */
    private Customer customer;

    /**
     *
     */
    private List<Product> products;

    /**
     * @return {@link Customer}
     */
    public Customer getCustomer()
    {
        return this.customer;
    }

    /**
     * @return {@link List}
     */
    public List<Product> getProducts()
    {
        return this.products;
    }

    /**
     * @param customer {@link Customer}
     */
    public void setCustomer(final Customer customer)
    {
        this.customer = customer;
    }

    /**
     * @param products {@link List}
     */
    public void setProducts(final List<Product> products)
    {
        this.products = products;
    }
}
