package com.np.order.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.np.order.dto.OrderInDto;
import com.np.order.dto.OrderOutDto;
import com.np.order.dto.UserDto;
import com.np.order.entity.Order;
import com.np.order.mapper.OrderMapper;
import com.np.order.repo.OrderRepository;
import com.np.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private SequenceGenerator sequenceGenerator;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public OrderOutDto saveOrder(OrderInDto orderIn) {

		Integer newOrderId = sequenceGenerator.generateNextOrderId();
		UserDto user = getUserDetails(orderIn.getUserId());
		Order order = new Order(newOrderId, orderIn.getFoodItemList(), orderIn.getRestaurant(), user);
		Order savedOrder = orderRepository.save(order);
		return OrderMapper.INSTANCE.mapOrderToOrderOutDto(savedOrder);
	}

	private UserDto getUserDetails(Integer userId) {
		UserDto user = restTemplate.getForObject("http://USER-SERVICE/user/getUser/"+userId, UserDto.class);
		return user;
	}

	@Override
	public List<OrderOutDto> getAllOrders() {
		List<OrderOutDto> orders = orderRepository.findAll().stream().map(order -> OrderMapper.INSTANCE.mapOrderToOrderOutDto(order)).collect(Collectors.toList());
		return orders;
	}
}
