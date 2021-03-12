package de.freese.benchmark.mapping.model.entity;

/**
 * @author Thomas Freese
 */
public class Customer
{
    /**
     *
     */
    private Address billingAddress;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Address shippingAddress;

    /**
     * @return {@link Address}
     */
    public Address getBillingAddress()
    {
        return this.billingAddress;
    }

    /**
     * @return String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return {@link Address}
     */
    public Address getShippingAddress()
    {
        return this.shippingAddress;
    }

    /**
     * @param billingAddress {@link Address}
     */
    public void setBillingAddress(final Address billingAddress)
    {
        this.billingAddress = billingAddress;
    }

    /**
     * @param name String
     */
    public void setName(final String name)
    {
        this.name = name;
    }

    /**
     * @param shippingAddress {@link Address}
     */
    public void setShippingAddress(final Address shippingAddress)
    {
        this.shippingAddress = shippingAddress;
    }
}
