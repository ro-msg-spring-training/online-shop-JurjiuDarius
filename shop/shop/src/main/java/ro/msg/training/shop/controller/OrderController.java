package ro.msg.training.shop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.training.shop.dto.order.OrderDTO;
import ro.msg.training.shop.dto.order.OrderDTOMapper;
import ro.msg.training.shop.entity.Order;
import ro.msg.training.shop.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public Order createOrder(@RequestBody OrderDTO orderDTO) {

        return orderService.createOrder(OrderDTOMapper.toOrder(orderDTO));
    }
}
