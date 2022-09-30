package ro.msg.training.shop.service.strategies;

import ro.msg.training.shop.entity.OrderDetail;
import ro.msg.training.shop.entity.Stock;
import ro.msg.training.shop.service.LocationService;

import java.util.ArrayList;

public interface LocationStrategy {
	
	ArrayList<Stock> orderLocationStrategy(LocationService locationService, ArrayList<OrderDetail> orderDetails);
	
}
