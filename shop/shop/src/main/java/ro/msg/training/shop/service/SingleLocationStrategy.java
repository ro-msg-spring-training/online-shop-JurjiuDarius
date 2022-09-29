package ro.msg.training.shop.service;

import ro.msg.training.shop.dto.product.ProductLocationDTO;
import ro.msg.training.shop.entity.*;
import ro.msg.training.shop.repository.LocationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class SingleLocationStrategy implements LocationStrategy {
    @Override
    public ArrayList<ProductLocationDTO> orderLocationStrategy(LocationRepository locationRepository, ArrayList<OrderDetail> orderDetails) {
        Iterable<Location> locations = locationRepository.findAll();
        HashMap<Product, Location> productLocations = new HashMap<Product, Location>();
        HashMap<Product, Integer> productQuantities = new HashMap<Product, Integer>();
        Boolean validLocation;
        ArrayList<ProductLocationDTO> productLocationDTOS = new ArrayList<ProductLocationDTO>();
        for (Location location : locations) {
            validLocation = true;
            for (OrderDetail orderDetail : orderDetails) {
                for (Stock stock : location.getStocks()) {
                    if (stock.getProduct().getId() == orderDetail.getProduct().getId() && stock.getQuantity() < orderDetail.getQuantity()) {
                        validLocation = false;
                        break;
                    }
                }
            }
            if (validLocation) {
                for (OrderDetail orderDetail : orderDetails) {
                    productLocationDTOS.add(new ProductLocationDTO(orderDetail.getProduct(), location, orderDetail.getQuantity()));
                }
                return productLocationDTOS;
            }
        }

        return productLocationDTOS;


    }
}
