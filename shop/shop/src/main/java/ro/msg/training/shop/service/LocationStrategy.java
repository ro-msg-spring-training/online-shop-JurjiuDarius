package ro.msg.training.shop.service;

import ro.msg.training.shop.dto.product.ProductLocationDTO;
import ro.msg.training.shop.entity.Location;
import ro.msg.training.shop.entity.OrderDetail;
import ro.msg.training.shop.entity.Product;
import ro.msg.training.shop.entity.Stock;
import ro.msg.training.shop.repository.LocationRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface LocationStrategy {
    ArrayList<ProductLocationDTO> orderLocationStrategy(LocationRepository locationRepository, ArrayList<OrderDetail> orderDetails);

}
