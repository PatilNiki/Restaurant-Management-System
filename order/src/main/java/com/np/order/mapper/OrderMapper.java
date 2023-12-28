package com.np.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.np.order.dto.OrderOutDto;
import com.np.order.entity.Order;

@Mapper
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	OrderOutDto mapOrderToOrderOutDto(Order order);
	Order mapOrderOutDtoToOrder(OrderOutDto orderOutDto);
}
