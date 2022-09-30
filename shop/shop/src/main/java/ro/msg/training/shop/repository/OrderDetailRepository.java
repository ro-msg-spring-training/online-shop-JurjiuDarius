package ro.msg.training.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.msg.training.shop.entity.OrderDetail;
import ro.msg.training.shop.entity.OrderDetailKey;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailKey> {

}
