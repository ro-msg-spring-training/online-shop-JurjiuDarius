package ro.msg.training.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.entity.*;
import ro.msg.training.shop.exception.OutOfStockException;
import ro.msg.training.shop.repository.OrderRepository;
import ro.msg.training.shop.service.strategy.LocationStrategy;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	private final LocationStrategy locationStrategy;
	
	private final LocationService locationService;
	
	private final StockService stockService;
	
	private final ProductService productService;
	
	private final OrderDetailService orderDetailService;
	
	private final CustomerService customerService;
	
	@Transactional
	public Order createOrder(Order order) throws RuntimeException {
		ArrayList<Stock> stocks = locationStrategy.orderLocationStrategy(locationService, new ArrayList<>(order.getOrderDetails()));
		if (stocks.isEmpty()) {
			throw new OutOfStockException("One or more of the selected items do not have sufficient stock.");
		}
		for (Stock stock : stocks) {
			Product product = stock.getProduct();
			Location location = stock.getLocation();
			int quantity = stock.getQuantity();
			boolean sufficientStock = false;
			for (Stock stock1 : location.getStocks()) {
				if (stock1.getProduct().getId() == product.getId() && stock1.getQuantity() >= quantity && stock1.getLocation().getId() == location.getId()) {
					sufficientStock = true;
					stock1.setQuantity(stock1.getQuantity() - quantity);
					stockService.createStock(stock1);
				}
			}
			if (!sufficientStock) {
				throw new OutOfStockException("Insufficient stock");
			}
		}
		order.setLocation(stocks.get(1).getLocation());
		order.setCustomer(customerService.getCustomerById(order.getCustomer().getId()));
		orderRepository.save(order);
		for (OrderDetail orderDetail : order.getOrderDetails()) {
			orderDetail.setProduct(productService.getProductById(orderDetail.getProduct().getId()));
			orderDetail.setOrder(order);
			orderDetail.setId(new OrderDetailKey());
			orderDetail.getId().setOrderId(orderDetail.getOrder().getId());
			orderDetail.getId().setProductId(orderDetail.getProduct().getId());
			orderDetailService.createOrderDetail(orderDetail);
		}
		return order;
	}
	
}
