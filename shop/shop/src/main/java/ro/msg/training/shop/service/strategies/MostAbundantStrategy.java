package ro.msg.training.shop.service.strategies;

import ro.msg.training.shop.entity.Location;
import ro.msg.training.shop.entity.OrderDetail;
import ro.msg.training.shop.entity.Product;
import ro.msg.training.shop.entity.Stock;
import ro.msg.training.shop.service.LocationService;

import java.util.ArrayList;
import java.util.HashMap;

public class MostAbundantStrategy implements LocationStrategy {
	
	@Override
	public ArrayList<Stock> orderLocationStrategy(LocationService locationService, ArrayList<OrderDetail> orderDetails) {
		Iterable<Location> locations = locationService.getLocations();
		HashMap<Product, Location> productLocations = new HashMap<>();
		HashMap<Product, Integer> productMaxQuantities = new HashMap<>();
		boolean suitableLocationExists;
		for (OrderDetail orderDetail : orderDetails) {
			suitableLocationExists = false;
			Product product = orderDetail.getProduct();
			productLocations.put(product, new Location());
			productMaxQuantities.put(product, 0);
			for (Location location : locations) {
				for (Stock stock : location.getStocks()) {
					if ((stock.getProduct().getId() == product.getId()) && stock.getQuantity() > productMaxQuantities.get(product)) {
						productMaxQuantities.put(product, stock.getQuantity());
						productLocations.put(product, location);
						suitableLocationExists = true;
					}
				}
			}
			if (!suitableLocationExists) {
				return new ArrayList<>();
			}
		}
		ArrayList<Stock> stocks = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			Product product = orderDetail.getProduct();
			Stock stock = new Stock();
			stock.setLocation(productLocations.get(product));
			stock.setQuantity(orderDetail.getQuantity());
			stock.setProduct(product);
			stocks.add(stock);
		}
		return stocks;
	}
	
}
