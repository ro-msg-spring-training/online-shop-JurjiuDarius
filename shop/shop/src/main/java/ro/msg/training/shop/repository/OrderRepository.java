package ro.msg.training.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.msg.training.shop.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
