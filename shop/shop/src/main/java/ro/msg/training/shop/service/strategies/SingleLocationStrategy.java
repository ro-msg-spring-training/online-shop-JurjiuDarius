package ro.msg.training.shop.service.strategies;

import ro.msg.training.shop.entity.Location;
import ro.msg.training.shop.entity.OrderDetail;
import ro.msg.training.shop.entity.Stock;
import ro.msg.training.shop.service.LocationService;

import java.util.ArrayList;

public class SingleLocationStrategy implements LocationStrategy {
	
	@Override
	public ArrayList<Stock> orderLocationStrategy(LocationService locationService, ArrayList<OrderDetail> orderDetails) {
		Iterable<Location> locations = locationService.getLocations();
		boolean validLocation;
		ArrayList<Stock> stocks = new ArrayList<>();
		for (Location location : locations) {
			
			validLocation = true;
			for (OrderDetail orderDetail : orderDetails) {
				for (Stock stock : location.getStocks()) {
					if (stock.getProduct().getId() == orderDetail.getProduct().getId() && stock.getQuantity() < orderDetail.getQuantity()) {
						validLocation = false;
						break;
					}
				}
			}
			if (validLocation) {
				for (OrderDetail orderDetail : orderDetails) {
					Stock stock = new Stock();
					stock.setLocation(location);
					stock.setQuantity(orderDetail.getQuantity());
					stock.setProduct(orderDetail.getProduct());
					stocks.add(stock);
					
				}
				return stocks;
			}
		}
		return new ArrayList<>();
	}
	
}
