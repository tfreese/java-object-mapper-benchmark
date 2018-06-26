package com.javaetmoi.benchmark.mapping.model.dto;

import java.util.List;

public class OrderDTO
{

    private List<ProductDTO> products;
    private String customerName;
    private String shippingStreetAddress;
    private String shippingCity;
    private String billingStreetAddress;
    private String billingCity;

    public String getBillingCity()
    {
        return this.billingCity;
    }

    public String getBillingStreetAddress()
    {
        return this.billingStreetAddress;
    }

    public String getCustomerName()
    {
        return this.customerName;
    }

    public List<ProductDTO> getProducts()
    {
        return this.products;
    }

    public String getShippingCity()
    {
        return this.shippingCity;
    }

    public String getShippingStreetAddress()
    {
        return this.shippingStreetAddress;
    }

    public void setBillingCity(final String billingCity)
    {
        this.billingCity = billingCity;
    }

    public void setBillingStreetAddress(final String billingStreetAddress)
    {
        this.billingStreetAddress = billingStreetAddress;
    }

    public void setCustomerName(final String customerName)
    {
        this.customerName = customerName;
    }

    public void setProducts(final List<ProductDTO> products)
    {
        this.products = products;
    }

    public void setShippingCity(final String shippingCity)
    {
        this.shippingCity = shippingCity;
    }

    public void setShippingStreetAddress(final String shippingStreetAddress)
    {
        this.shippingStreetAddress = shippingStreetAddress;
    }
}