package ro.msg.training.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.msg.training.shop.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
}
