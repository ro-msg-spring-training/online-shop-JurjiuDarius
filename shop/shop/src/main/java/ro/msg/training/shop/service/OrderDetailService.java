package ro.msg.training.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.entity.OrderDetail;
import ro.msg.training.shop.repository.OrderDetailRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderDetailService {
	
	private final OrderDetailRepository orderDetailRepository;
	
	public List<OrderDetail> getOrderDetails() {
		ArrayList<OrderDetail> orderDetails = new ArrayList<>();
		Iterable<OrderDetail> orderDetailIterable = orderDetailRepository.findAll();
		orderDetailIterable.forEach(orderDetails::add);
		return orderDetails;
	}
	
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		return orderDetailRepository.save(orderDetail);
	}
	
}
