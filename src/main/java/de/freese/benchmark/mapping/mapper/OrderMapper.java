package de.freese.benchmark.mapping.mapper;

import java.util.function.Function;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;

/**
 * @author Thomas Freese
 */
@FunctionalInterface
public interface OrderMapper extends Function<Order, OrderDTO>
{
    /**
     * @see java.util.function.Function#apply(java.lang.Object)
     */
    @Override
    public default OrderDTO apply(final Order t)
    {
        return map(t);
    }

    /**
     * @param source {@link Order}
     * @return {@link OrderDTO}
     */
    public OrderDTO map(Order source);
}