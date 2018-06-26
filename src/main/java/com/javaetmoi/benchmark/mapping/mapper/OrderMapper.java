package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

/**
 * @author Thomas Freese
 */
@FunctionalInterface
public interface OrderMapper
{
    /**
     * @param source {@link Order}
     * @return {@link OrderDTO}
     */
    public OrderDTO map(Order source);
}