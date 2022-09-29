package ro.msg.training.shop.dto.order;

import ro.msg.training.shop.entity.*;

import java.util.ArrayList;

public class OrderDTOMapper {


    public static Order toOrder(OrderDTO dto) {
        Order order = new Order();
        order.setLocation(new Location());
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setStreetAddress(dto.getStreetAddress());
        address.setCountry(dto.getCountry());
        address.setCounty(dto.getCounty());
        order.setAddress(address);
        ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        for (OrderDetailDTO orderDetailDTO : dto.getOrderDetailDTOS()) {
            OrderDetail orderDetail = new OrderDetail();
            Product product = new Product();
            product.setId(orderDetailDTO.getProductId());
            orderDetail.setQuantity(orderDetailDTO.getQuantity());
            orderDetail.setProduct(product);
            orderDetails.add(orderDetail);
        }
        order.setOrderDetails(orderDetails);


        return order;
    }
}
