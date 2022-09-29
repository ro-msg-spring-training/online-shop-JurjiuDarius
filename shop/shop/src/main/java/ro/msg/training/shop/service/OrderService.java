package ro.msg.training.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.dto.product.ProductLocationDTO;
import ro.msg.training.shop.entity.*;
import ro.msg.training.shop.repository.LocationRepository;
import ro.msg.training.shop.repository.OrderRepository;
import ro.msg.training.shop.repository.StockRepository;

import java.util.ArrayList;

@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final LocationRepository locationRepository;
    private final StockRepository stockRepository;

    public OrderService(OrderRepository orderRepository, LocationRepository locationRepository, StockRepository stockRepository) {
        this.orderRepository = orderRepository;
        this.locationRepository = locationRepository;
        this.stockRepository = stockRepository;
    }

    public Order createOrder(Order order) throws RuntimeException {

        ArrayList<ProductLocationDTO> productLocationDTOS = StrategyConfiguration.getLocationStrategy().
                orderLocationStrategy(locationRepository, new ArrayList<OrderDetail>(order.getOrderDetails()));
        if (productLocationDTOS.isEmpty()) return null;

        for (ProductLocationDTO productLocationDTO : productLocationDTOS) {
            Product product = productLocationDTO.getProduct();
            Location location = productLocationDTO.getLocation();
            Integer quantity = productLocationDTO.getQuantity();
            log.info(product.getName() + " " + location.getName() + " " + quantity);
            Boolean sufficientStock = false;
            for (Stock stock : location.getStocks()) {
                if (stock.getProduct().getId() == product.getId() && stock.getQuantity() >= quantity && stock.getLocation().getId() == location.getId()) {
                    sufficientStock = true;
                    stock.setQuantity(stock.getQuantity() - quantity);
                    stockRepository.save(stock);
                }
            }
            if (!sufficientStock) {
                return null;
            }
        }
        return order;
    }


}
