package de.freese.benchmark.mapping.model.dto;

import java.util.List;

/**
 * @author Thomas Freese
 */
public class OrderDTO
{
    /**
     *
     */
    private String billingCity;

    /**
     *
     */
    private String billingStreetAddress;

    /**
     *
     */
    private String customerName;

    /**
     *
     */
    private List<ProductDTO> products;

    /**
     *
     */
    private String shippingCity;

    /**
     *
     */
    private String shippingStreetAddress;

    /**
     * @return String
     */
    public String getBillingCity()
    {
        return this.billingCity;
    }

    /**
     * @return String
     */
    public String getBillingStreetAddress()
    {
        return this.billingStreetAddress;
    }

    /**
     * @return String
     */
    public String getCustomerName()
    {
        return this.customerName;
    }

    /**
     * @return {@link List}
     */
    public List<ProductDTO> getProducts()
    {
        return this.products;
    }

    /**
     * @return String
     */
    public String getShippingCity()
    {
        return this.shippingCity;
    }

    /**
     * @return String
     */
    public String getShippingStreetAddress()
    {
        return this.shippingStreetAddress;
    }

    /**
     * @param billingCity String
     */
    public void setBillingCity(final String billingCity)
    {
        this.billingCity = billingCity;
    }

    /**
     * @param billingStreetAddress String
     */
    public void setBillingStreetAddress(final String billingStreetAddress)
    {
        this.billingStreetAddress = billingStreetAddress;
    }

    /**
     * @param customerName String
     */
    public void setCustomerName(final String customerName)
    {
        this.customerName = customerName;
    }

    /**
     * @param products {@link List}
     */
    public void setProducts(final List<ProductDTO> products)
    {
        this.products = products;
    }

    /**
     * @param shippingCity String
     */
    public void setShippingCity(final String shippingCity)
    {
        this.shippingCity = shippingCity;
    }

    /**
     * @param shippingStreetAddress String
     */
    public void setShippingStreetAddress(final String shippingStreetAddress)
    {
        this.shippingStreetAddress = shippingStreetAddress;
    }
}
