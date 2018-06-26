package com.javaetmoi.benchmark.mapping.model.entity;

public class Customer
{
    private String name;
    private Address shippingAddress;
    private Address billingAddress;

    public Address getBillingAddress()
    {
        return this.billingAddress;
    }

    public String getName()
    {
        return this.name;
    }

    public Address getShippingAddress()
    {
        return this.shippingAddress;
    }

    public void setBillingAddress(final Address billingAddress)
    {
        this.billingAddress = billingAddress;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setShippingAddress(final Address shippingAddress)
    {
        this.shippingAddress = shippingAddress;
    }
}