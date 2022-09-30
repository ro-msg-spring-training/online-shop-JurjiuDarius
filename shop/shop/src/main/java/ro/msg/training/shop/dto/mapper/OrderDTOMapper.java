package ro.msg.training.shop.dto.mapper;

import ro.msg.training.shop.dto.order.OrderDetailDTO;
import ro.msg.training.shop.dto.order.OrderReadDTO;
import ro.msg.training.shop.dto.order.OrderWriteDTO;
import ro.msg.training.shop.entity.*;

import java.sql.Date;
import java.util.ArrayList;

public class OrderDTOMapper {
	
	public static Order toOrder(OrderReadDTO dto) {
		Order order = new Order();
		order.setLocation(new Location());
		Address address = new Address();
		address.setCity(dto.getCity());
		address.setStreetAddress(dto.getStreetAddress());
		address.setCountry(dto.getCountry());
		address.setCounty(dto.getCounty());
		order.setAddress(address);
		order.setCustomer(new Customer());
		order.getCustomer().setId(dto.getCustomerId());
		order.setCreatedAt(new Date(System.currentTimeMillis()));
		addOrderDetails(dto, order);
		return order;
	}
	
	private static void addOrderDetails(OrderReadDTO dto, Order order) {
		ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		for (OrderDetailDTO orderDetailDTO : dto.getOrderDetailDTOS()) {
			OrderDetail orderDetail = new OrderDetail();
			Product product = new Product();
			product.setId(orderDetailDTO.getProductId());
			orderDetail.setQuantity(orderDetailDTO.getQuantity());
			orderDetail.setProduct(product);
			orderDetails.add(orderDetail);
		}
		order.setOrderDetails(orderDetails);
	}
	
	public static OrderWriteDTO toDto(Order order) {
		OrderWriteDTO orderWriteDTO = new OrderWriteDTO();
		orderWriteDTO.setCity(order.getAddress().getCity());
		orderWriteDTO.setCounty(order.getAddress().getCounty());
		orderWriteDTO.setStreetAddress(order.getAddress().getStreetAddress());
		orderWriteDTO.setCountry(order.getAddress().getCountry());
		orderWriteDTO.setCreatedAt(order.getCreatedAt());
		orderWriteDTO.setCustomerId(order.getCustomer().getId());
		return orderWriteDTO;
	}
	
}
