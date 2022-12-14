package ro.msg.training.shop.service.strategy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import ro.msg.training.shop.entity.*;
import ro.msg.training.shop.service.LocationService;

import java.util.ArrayList;

@SpringBootTest
@Profile("test")
class SingleLocationStrategyTest {
	
	@MockBean
	private LocationService locationService;
	
	@Test
	void testSuccessAndFailureSingleLocationStrategy() {
		SingleLocationStrategy singleLocationStrategy = new SingleLocationStrategy();
		Product laptop = new Product();
		Product shoes = new Product();
		laptop.setId(1);
		shoes.setId(2);
		Location deva = new Location();
		deva.setId(1);
		deva.setName("Deva");
		Location cluj = new Location();
		cluj.setName("Cluj");
		deva.setId(2);
		
		setLocationStocks(deva, cluj, laptop, shoes);
		
		OrderDetail orderDetail1 = new OrderDetail(new OrderDetailKey(), 10, laptop, new Order());
		OrderDetail orderDetail2 = new OrderDetail(new OrderDetailKey(), 20, shoes, new Order());
		
		ArrayList<OrderDetail> orderDetails = new ArrayList<>();
		orderDetails.add(orderDetail1);
		orderDetails.add(orderDetail2);
		
		ArrayList<Location> locations = new ArrayList<>();
		locations.add(deva);
		locations.add(cluj);
		
		Mockito.when(locationService.getLocations()).thenReturn(locations);
		ArrayList<Stock> stocks = singleLocationStrategy.orderLocationStrategy(locationService, orderDetails);
		
		assert (!stocks.isEmpty());
		assert (stocks.get(0) != null && stocks.get(0).getLocation() != null && stocks.get(0).getProduct() != null);
		for (Stock stock : stocks) {
			assert stock.getLocation().equals(deva);
			assert !stock.getProduct().equals(laptop) || stock.getQuantity() == 10;
			assert !stock.getProduct().equals(shoes) || stock.getQuantity() == 20;
		}
		
		OrderDetail failedDetail = new OrderDetail(new OrderDetailKey(), 10000, shoes, new Order());
		ArrayList<OrderDetail> failedDetails = new ArrayList<>();
		failedDetails.add(failedDetail);
		stocks = singleLocationStrategy.orderLocationStrategy(locationService, failedDetails);
		assert stocks.isEmpty();
	}
	
	private void setLocationStocks(Location location1, Location location2, Product product1, Product product2) {
		Stock stock1 = new Stock(new StockKey(), 20, location1, product1);
		Stock stock2 = new Stock(new StockKey(), 40, location1, product2);
		Stock stock3 = new Stock(new StockKey(), 100, location2, product1);
		Stock stock4 = new Stock(new StockKey(), 10, location2, product2);
		location1.setStocks(new ArrayList<>());
		location2.setStocks(new ArrayList<>());
		location1.getStocks().add(stock1);
		location1.getStocks().add(stock2);
		location2.getStocks().add(stock3);
		location2.getStocks().add(stock4);
	}
	
}