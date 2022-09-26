package ro.msg.training.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.msg.training.shop.Entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
