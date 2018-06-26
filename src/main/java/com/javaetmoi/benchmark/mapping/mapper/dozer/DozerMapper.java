package com.javaetmoi.benchmark.mapping.mapper.dozer;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import java.util.Arrays;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

public class DozerMapper implements OrderMapper
{

    private Mapper beanMapper = DozerBeanMapperBuilder.create().withMappingFiles(Arrays.asList("com/javaetmoi/benchmark/mapping/mapper/dozer/dozer.xml")).build();

    public DozerMapper()
    {
        super();
    }

    @Override
    public OrderDTO map(Order source)
    {
        return beanMapper.map(source, OrderDTO.class);
    }
}
