package com.np.order.service;

import java.util.List;

import com.np.order.dto.OrderInDto;
import com.np.order.dto.OrderOutDto;

public interface OrderService {

	OrderOutDto saveOrder(OrderInDto orderIn);

	List<OrderOutDto> getAllOrders();

}
