package ro.msg.training.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.msg.training.shop.entity.Stock;
import ro.msg.training.shop.entity.StockKey;

@Repository
public interface StockRepository extends CrudRepository<Stock, StockKey> {
}
