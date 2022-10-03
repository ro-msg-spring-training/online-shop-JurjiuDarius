package ro.msg.training.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.entity.Stock;
import ro.msg.training.shop.repository.StockRepository;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class StockService {
	
	private final StockRepository stockRepository;
	
	public ArrayList<Stock> getStocks() {
		ArrayList<Stock> stocks = new ArrayList<>();
		Iterable<Stock> stockIterable = stockRepository.findAll();
		stockIterable.forEach(stocks::add);
		return stocks;
	}
	
	public Stock createStock(Stock stock) {
		return stockRepository.save(stock);
	}
	
}