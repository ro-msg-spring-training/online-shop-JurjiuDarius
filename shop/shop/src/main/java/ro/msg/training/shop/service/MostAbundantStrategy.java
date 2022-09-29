package ro.msg.training.shop.service;

import com.sun.source.tree.Tree;
import ro.msg.training.shop.dto.product.ProductLocationDTO;
import ro.msg.training.shop.entity.Location;
import ro.msg.training.shop.entity.OrderDetail;
import ro.msg.training.shop.entity.Product;
import ro.msg.training.shop.entity.Stock;
import ro.msg.training.shop.repository.LocationRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MostAbundantStrategy implements LocationStrategy {
    @Override
    public ArrayList<ProductLocationDTO> orderLocationStrategy(LocationRepository locationRepository, ArrayList<OrderDetail> orderDetails) {
        Iterable<Location> locations = locationRepository.findAll();
        HashMap<Product, Location> productLocations = new HashMap<Product, Location>();
        HashMap<Product, Integer> productMaxQuantities = new HashMap<Product, Integer>();
        Boolean suitableLocationExists = true;
        for (OrderDetail orderDetail : orderDetails) {
            suitableLocationExists = false;
            Product product = orderDetail.getProduct();
            productLocations.put(product, new Location());
            productMaxQuantities.put(product, 0);
            for (Location location : locations) {
                for (Stock stock :
                        location.getStocks()) {
                    if ((stock.getProduct().getId() == product.getId()) && stock.getQuantity() > productMaxQuantities.get(product)) {
                        productMaxQuantities.put(product, stock.getQuantity());
                        productLocations.put(product, location);
                        suitableLocationExists = true;
                    }
                }
            }
            if (!suitableLocationExists) {
                return new ArrayList<ProductLocationDTO>();
            }
        }
        ArrayList<ProductLocationDTO> productLocationDTOS = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            Product product = orderDetail.getProduct();
            productLocationDTOS.add(new ProductLocationDTO(product, productLocations.get(product), orderDetail.getQuantity()));
        }
        return productLocationDTOS;
    }
}
