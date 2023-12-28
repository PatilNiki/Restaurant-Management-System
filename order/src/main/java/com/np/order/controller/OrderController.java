package com.np.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.order.dto.OrderInDto;
import com.np.order.dto.OrderOutDto;
import com.np.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderOutDto> saveOrder(@RequestBody OrderInDto orderIn){
		OrderOutDto orderDto = orderService.saveOrder(orderIn);
		return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrderOutDto>> getAllOrders(){
		List<OrderOutDto> orders = orderService.getAllOrders();
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
}
