package ro.msg.training.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.training.shop.dto.mapper.OrderDTOMapper;
import ro.msg.training.shop.dto.order.OrderReadDTO;
import ro.msg.training.shop.dto.order.OrderWriteDTO;
import ro.msg.training.shop.service.OrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@PostMapping()
	public OrderWriteDTO createOrder(@RequestBody OrderReadDTO orderReadDTO) {
		return OrderDTOMapper.toDto(orderService.createOrder(OrderDTOMapper.toOrder(orderReadDTO)));
	}
	
}
